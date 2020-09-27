package com.c2.hospital.admissionservice.controllers;

import com.c2.hospital.admissionservice.co.AdmissionCO;
import com.c2.hospital.admissionservice.exception.ResourceNotFoundException;
import com.c2.hospital.admissionservice.model.AdmissionEntity;
import com.c2.hospital.admissionservice.repository.AdmissionRepository;
import com.c2.hospital.admissionservice.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private AdmissionRepository admissionRepository;

    @GetMapping("/")
    public List<AdmissionEntity> getAllAdmissionEntitys() {
        return admissionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdmissionEntity> getAdmissionEntityById(@PathVariable(value = "id") int admissionEntityId) throws ResourceNotFoundException {
        AdmissionEntity AdmissionEntity = admissionRepository.findById(admissionEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionEntity not found for this id :: " + admissionEntityId));
        return ResponseEntity.ok().body(AdmissionEntity);
    }

    @PostMapping("/")
    public AdmissionEntity createAdmissionEntity(@Valid @RequestBody AdmissionEntity AdmissionEntity) {
        return admissionRepository.save(AdmissionEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdmissionEntity> updateAdmissionEntity(@PathVariable(value = "id") int admissionEntityId,  @Valid @RequestBody AdmissionEntity admissionEntityDetails) throws ResourceNotFoundException {
        AdmissionEntity admissionEntity = admissionRepository.findById(admissionEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionEntity not found for this id :: " + admissionEntityId));

        if(null != admissionEntityDetails.getCheckIn())
        {
            admissionEntity.setCheckIn(admissionEntityDetails.getCheckIn());
        }
        admissionEntity.setCheckOut(admissionEntityDetails.getCheckOut());
        long nrOfDays = DAYS.between(admissionEntity.getCheckIn().toInstant(), admissionEntityDetails.getCheckOut().toInstant());
        admissionEntity.setNbrOfDays((int) nrOfDays+1);
        final AdmissionEntity updatedAdmissionEntity = admissionRepository.save(admissionEntity);
        return ResponseEntity.ok(updatedAdmissionEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAdmissionEntity(@PathVariable(value = "id") int admissionEntityId)
            throws ResourceNotFoundException {
        AdmissionEntity admissionEntity = admissionRepository.findById(admissionEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionEntity not found for this id :: " + admissionEntityId));

        admissionRepository.delete(admissionEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("{id}/services")
    public AdmissionCO getAdmissionServicesById(@PathVariable(value = "id") int admissionEntityId) throws ResourceNotFoundException {
        return admissionService.findAdmissionServiceById(admissionEntityId);
    }

    @PostMapping("/save")
    public AdmissionCO saveAdmission(@Valid @RequestBody AdmissionCO admissionCO) throws ResourceNotFoundException{
        return admissionService.saveAdmission(admissionCO);
    }
}
