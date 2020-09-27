package com.c2.hospital.admissionservice.controllers;

import com.c2.hospital.admissionservice.exception.ResourceNotFoundException;
import com.c2.hospital.admissionservice.model.AdmissionServiceEntity;
import com.c2.hospital.admissionservice.repository.AdmissionServiceRepository;
import com.c2.hospital.admissionservice.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/admissionService")
public class AdmissionServiceController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private AdmissionServiceRepository admissionServiceRepository;

    @GetMapping("/")
    public List<AdmissionServiceEntity> getAllAdmissionServiceEntitys() {
        return admissionServiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdmissionServiceEntity> getAdmissionServiceEntityById(@PathVariable(value = "id") int admissionServiceEntityId) throws ResourceNotFoundException {
        AdmissionServiceEntity AdmissionServiceEntity = admissionServiceRepository.findById(admissionServiceEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionServiceEntity not found for this id :: " + admissionServiceEntityId));
        return ResponseEntity.ok().body(AdmissionServiceEntity);
    }

    @PostMapping("/")
    public AdmissionServiceEntity createAdmissionServiceEntity(@Valid @RequestBody AdmissionServiceEntity AdmissionServiceEntity) {
        return admissionServiceRepository.save(AdmissionServiceEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdmissionServiceEntity> updateAdmissionServiceEntity(@PathVariable(value = "id") int admissionServiceEntityId,  @Valid @RequestBody AdmissionServiceEntity admissionServiceEntityDetails) throws ResourceNotFoundException {
        AdmissionServiceEntity admissionServiceEntity = admissionServiceRepository.findById(admissionServiceEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionServiceEntity not found for this id :: " + admissionServiceEntityId));

        admissionServiceEntity.setServiceId(admissionServiceEntityDetails.getServiceId());
        admissionServiceEntity.setAdmissionId(admissionServiceEntityDetails.getAdmissionId());
        admissionServiceEntity.setServiceDate(admissionServiceEntityDetails.getServiceDate());
        admissionServiceEntity.setServiceResult(admissionServiceEntityDetails.getServiceResult());
        final AdmissionServiceEntity updatedAdmissionServiceEntity = admissionServiceRepository.save(admissionServiceEntity);
        return ResponseEntity.ok(updatedAdmissionServiceEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAdmissionServiceEntity(@PathVariable(value = "id") int admissionServiceEntityId)
            throws ResourceNotFoundException {
        AdmissionServiceEntity admissionServiceEntity = admissionServiceRepository.findById(admissionServiceEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionServiceEntity not found for this id :: " + admissionServiceEntityId));

        admissionServiceRepository.delete(admissionServiceEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
