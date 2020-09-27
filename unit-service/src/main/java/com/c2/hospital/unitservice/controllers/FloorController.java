package com.c2.hospital.unitservice.controllers;

import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.FloorEntity;
import com.c2.hospital.unitservice.repository.FloorRepository;
import com.c2.hospital.unitservice.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/floor")
public class FloorController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private FloorRepository floorRepository;

    // Get List of all floors in covid 19 bloc
    @GetMapping("/")
    public List<FloorEntity> getAllFloorEntitys() {
        return floorRepository.findAll();
    }

    // Get floor by ID
    @GetMapping("/{id}")
    public ResponseEntity<FloorEntity> getFloorEntityById(@PathVariable(value = "id") int floorEntityId) throws ResourceNotFoundException {
        FloorEntity FloorEntity = floorRepository.findById(floorEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("FloorEntity not found for this id :: " + floorEntityId));
        return ResponseEntity.ok().body(FloorEntity);
    }

    // Add new floor
    @PostMapping("/")
    public FloorEntity createFloorEntity(@Valid @RequestBody FloorEntity FloorEntity) {
        return floorRepository.save(FloorEntity);
    }

    // Update floor code, parent bloc, medical specialization of the floor by ID
    @PutMapping("/{id}")
    public ResponseEntity<FloorEntity> updateFloorEntity(@PathVariable(value = "id") int floorEntityId,  @Valid @RequestBody FloorEntity floorEntityDetails) throws ResourceNotFoundException {
        FloorEntity floorEntity = floorRepository.findById(floorEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("FloorEntity not found for this id :: " + floorEntityId));

        floorEntity.setNbr(floorEntityDetails.getNbr());
        floorEntity.setBloc(floorEntityDetails.getBloc());
        floorEntity.setSpecialization(floorEntityDetails.getSpecialization());
        final FloorEntity updatedFloorEntity = floorRepository.save(floorEntity);
        return ResponseEntity.ok(updatedFloorEntity);
    }

    // Delete floor by ID
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteFloorEntity(@PathVariable(value = "id") int floorEntityId)
            throws ResourceNotFoundException {
        FloorEntity floorEntity = floorRepository.findById(floorEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("FloorEntity not found for this id :: " + floorEntityId));

        floorRepository.delete(floorEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
