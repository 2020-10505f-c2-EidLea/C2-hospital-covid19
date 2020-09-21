package com.c2.hospital.equipmentservice.controllers;

import com.c2.hospital.equipmentservice.exception.ResourceNotFoundException;
import com.c2.hospital.equipmentservice.model.EquipmentTypeEntity;
import com.c2.hospital.equipmentservice.repository.EquipmentTypeRepository;
import com.c2.hospital.equipmentservice.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipmentType")
public class EquipmentTypeController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @GetMapping("/")
    public List<EquipmentTypeEntity> getAllEquipmentTypeEntitys() {
        return equipmentTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentTypeEntity> getEquipmentTypeEntityById(@PathVariable(value = "id") int equipmentTypeEntityId) throws ResourceNotFoundException {
        EquipmentTypeEntity EquipmentTypeEntity = equipmentTypeRepository.findById(equipmentTypeEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentTypeEntity not found for this id :: " + equipmentTypeEntityId));
        return ResponseEntity.ok().body(EquipmentTypeEntity);
    }

    @PostMapping("/")
    public EquipmentTypeEntity createEquipmentTypeEntity(@Valid @RequestBody EquipmentTypeEntity EquipmentTypeEntity) {
        return equipmentTypeRepository.save(EquipmentTypeEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentTypeEntity> updateEquipmentTypeEntity(@PathVariable(value = "id") int equipmentTypeEntityId,  @Valid @RequestBody EquipmentTypeEntity equipmentTypeEntityDetails) throws ResourceNotFoundException {
        EquipmentTypeEntity equipmentTypeEntity = equipmentTypeRepository.findById(equipmentTypeEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentTypeEntity not found for this id :: " + equipmentTypeEntityId));

        equipmentTypeEntity.setName(equipmentTypeEntityDetails.getName());
        equipmentTypeEntity.setDescription(equipmentTypeEntityDetails.getDescription());
        final EquipmentTypeEntity updatedEquipmentTypeEntity = equipmentTypeRepository.save(equipmentTypeEntity);
        return ResponseEntity.ok(updatedEquipmentTypeEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEquipmentTypeEntity(@PathVariable(value = "id") int equipmentTypeEntityId)
            throws ResourceNotFoundException {
        EquipmentTypeEntity equipmentTypeEntity = equipmentTypeRepository.findById(equipmentTypeEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentTypeEntity not found for this id :: " + equipmentTypeEntityId));

        equipmentTypeRepository.delete(equipmentTypeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
