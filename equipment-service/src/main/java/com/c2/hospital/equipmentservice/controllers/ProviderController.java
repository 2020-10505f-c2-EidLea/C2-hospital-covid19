package com.c2.hospital.equipmentservice.controllers;

import com.c2.hospital.equipmentservice.exception.ResourceNotFoundException;
import com.c2.hospital.equipmentservice.model.ProviderEntity;
import com.c2.hospital.equipmentservice.repository.ProviderRepository;
import com.c2.hospital.equipmentservice.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("/")
    public List<ProviderEntity> getAllProviderEntitys() {
        return providerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderEntity> getProviderEntityById(@PathVariable(value = "id") int providerEntityId) throws ResourceNotFoundException {
        ProviderEntity ProviderEntity = providerRepository.findById(providerEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProviderEntity not found for this id :: " + providerEntityId));
        return ResponseEntity.ok().body(ProviderEntity);
    }

    @PostMapping("/")
    public ProviderEntity createProviderEntity(@Valid @RequestBody ProviderEntity ProviderEntity) {
        return providerRepository.save(ProviderEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderEntity> updateProviderEntity(@PathVariable(value = "id") int providerEntityId,  @Valid @RequestBody ProviderEntity providerEntityDetails) throws ResourceNotFoundException {
        ProviderEntity providerEntity = providerRepository.findById(providerEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProviderEntity not found for this id :: " + providerEntityId));

        providerEntity.setName(providerEntityDetails.getName());
        providerEntity.setPhone(providerEntityDetails.getPhone());
        providerEntity.setEmail(providerEntityDetails.getEmail());
        final ProviderEntity updatedProviderEntity = providerRepository.save(providerEntity);
        return ResponseEntity.ok(updatedProviderEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProviderEntity(@PathVariable(value = "id") int providerEntityId)
            throws ResourceNotFoundException {
        ProviderEntity providerEntity = providerRepository.findById(providerEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProviderEntity not found for this id :: " + providerEntityId));

        providerRepository.delete(providerEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
