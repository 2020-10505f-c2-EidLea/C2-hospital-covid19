package com.c2.hospital.equipmentservice.controllers;

import com.c2.hospital.equipmentservice.co.EquipmentCO;
import com.c2.hospital.equipmentservice.exception.ResourceNotFoundException;
import com.c2.hospital.equipmentservice.model.EquipmentEntity;
import com.c2.hospital.equipmentservice.repository.EquipmentRepository;
import com.c2.hospital.equipmentservice.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/")
    public List<EquipmentEntity> getAllEquipmentEntitys() {
        return equipmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentEntity> getEquipmentEntityById(@PathVariable(value = "id") int equipmentEntityId) throws ResourceNotFoundException {
        EquipmentEntity EquipmentEntity = equipmentRepository.findById(equipmentEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentEntity not found for this id :: " + equipmentEntityId));
        return ResponseEntity.ok().body(EquipmentEntity);
    }

    @PostMapping("/")
    public EquipmentEntity createEquipmentEntity(@Valid @RequestBody EquipmentEntity EquipmentEntity) {
        return equipmentRepository.save(EquipmentEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentEntity> updateEquipmentEntity(@PathVariable(value = "id") int equipmentEntityId,  @Valid @RequestBody EquipmentEntity equipmentEntityDetails) throws ResourceNotFoundException {
        EquipmentEntity equipmentEntity = equipmentRepository.findById(equipmentEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentEntity not found for this id :: " + equipmentEntityId));

        if(0 != equipmentEntityDetails.getIdType())
        {
            equipmentEntity.setIdType(equipmentEntityDetails.getIdType());
        }

        if(0 != equipmentEntityDetails.getProviderId())
        {
            equipmentEntity.setProviderId(equipmentEntityDetails.getProviderId());
        }


        if(0 != equipmentEntityDetails.getQuantity())
        {
            equipmentEntity.setQuantity(equipmentEntityDetails.getQuantity());
        }

        if(0 != equipmentEntityDetails.getDisponibility())
        {
            equipmentEntity.setDisponibility(equipmentEntityDetails.getDisponibility());
        }
        final EquipmentEntity updatedEquipmentEntity = equipmentRepository.save(equipmentEntity);
        return ResponseEntity.ok(updatedEquipmentEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEquipmentEntity(@PathVariable(value = "id") int equipmentEntityId)
            throws ResourceNotFoundException {
        EquipmentEntity equipmentEntity = equipmentRepository.findById(equipmentEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentEntity not found for this id :: " + equipmentEntityId));

        equipmentRepository.delete(equipmentEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @GetMapping("/available")
    public List<EquipmentCO> getAvailableEquipment() {
        return equipmentService.findAvailableEquipment();
    }

    @GetMapping("/notAvailable")
    public List<EquipmentCO> getNonAvailableEquipment() {
        return equipmentService.findNonAvailableEquipment();
    }

    @GetMapping("/{id}/info")
    public ResponseEntity<EquipmentCO> getEquipmentById(@PathVariable(value = "id") int equipmentEntityId) throws ResourceNotFoundException {
        EquipmentEntity EquipmentEntity = equipmentRepository.findById(equipmentEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentEntity not found for this id :: " + equipmentEntityId));
        return ResponseEntity.ok().body(equipmentService.findEquipmentDetails(EquipmentEntity));
    }

    @GetMapping("/{id}/add/{qty}")
    public ResponseEntity<EquipmentCO> addQtyEquipmentById(@PathVariable(value = "id") int equipmentEntityId, @PathVariable(value = "qty") int qty) throws ResourceNotFoundException {
        EquipmentEntity EquipmentEntity = equipmentService.changeQty(equipmentEntityId, Math.abs(qty), Math.signum(qty));
        return ResponseEntity.ok().body(equipmentService.findEquipmentDetails(EquipmentEntity));
    }

    @GetMapping("/{id}/consume/{qty}")
    public ResponseEntity<EquipmentCO> consumeQtyEquipmentById(@PathVariable(value = "id") int equipmentEntityId, @PathVariable(value = "qty") int qty) throws ResourceNotFoundException {
        EquipmentEntity EquipmentEntity = equipmentService.changeQty(equipmentEntityId, Math.abs(qty), Math.signum(-1*qty));
        return ResponseEntity.ok().body(equipmentService.findEquipmentDetails(EquipmentEntity));
    }

    @GetMapping("/type/{id}/info")
    public List<EquipmentCO> getEquipmentByTypeId(@PathVariable(value = "id") int equipmentEntityId) throws ResourceNotFoundException {
        return equipmentService.findByTypeId(equipmentEntityId);
    }

    @GetMapping("/service/{id}/info")
    public List<EquipmentCO> getEquipmentByServiceId(@PathVariable(value = "id") int equipmentEntityId) throws ResourceNotFoundException {
        return equipmentService.findByServiceId(equipmentEntityId);
    }
}
