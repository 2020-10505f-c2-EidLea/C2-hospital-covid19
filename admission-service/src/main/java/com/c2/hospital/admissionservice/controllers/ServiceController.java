package com.c2.hospital.admissionservice.controllers;

import com.c2.hospital.admissionservice.exception.ResourceNotFoundException;
import com.c2.hospital.admissionservice.model.ServiceEntity;
import com.c2.hospital.admissionservice.repository.ServiceRepository;
import com.c2.hospital.admissionservice.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/")
    public List<ServiceEntity> getAllServiceEntitys() {
        return serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getServiceEntityById(@PathVariable(value = "id") int serviceEntityId) throws ResourceNotFoundException {
        ServiceEntity ServiceEntity = serviceRepository.findById(serviceEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceEntity not found for this id :: " + serviceEntityId));
        return ResponseEntity.ok().body(ServiceEntity);
    }

    @PostMapping("/")
    public ServiceEntity createServiceEntity(@Valid @RequestBody ServiceEntity ServiceEntity) {
        return serviceRepository.save(ServiceEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateServiceEntity(@PathVariable(value = "id") int serviceEntityId,  @Valid @RequestBody ServiceEntity serviceEntityDetails) throws ResourceNotFoundException {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceEntity not found for this id :: " + serviceEntityId));

        serviceEntity.setDescription(serviceEntityDetails.getDescription());
        serviceEntity.setAvailableService(serviceEntityDetails.isAvailableService());
        final ServiceEntity updatedServiceEntity = serviceRepository.save(serviceEntity);
        return ResponseEntity.ok(updatedServiceEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteServiceEntity(@PathVariable(value = "id") int serviceEntityId)
            throws ResourceNotFoundException {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceEntity not found for this id :: " + serviceEntityId));

        serviceRepository.delete(serviceEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
