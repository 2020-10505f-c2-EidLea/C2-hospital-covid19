package com.c2.hospital.unitservice.controllers;

import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.TypeEntity;
import com.c2.hospital.unitservice.repository.TypeRepository;
import com.c2.hospital.unitservice.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/types")
public class TypesController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private TypeRepository typeRepository;

    // Get list of all unit types
    @GetMapping("/")
    public List<TypeEntity> getAllTypeEntitys() {
        return typeRepository.findAll();
    }

    // Get unit type by ID
    @GetMapping("/{id}")
    public ResponseEntity<TypeEntity> getTypeEntityById(@PathVariable(value = "id") int typesEntityId) throws ResourceNotFoundException {
        TypeEntity TypeEntity = typeRepository.findById(typesEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("TypeEntity not found for this id :: " + typesEntityId));
        return ResponseEntity.ok().body(TypeEntity);
    }

    // Add new unit type
    @PostMapping("/")
    public TypeEntity createTypeEntity(@Valid @RequestBody TypeEntity TypeEntity) {
        return typeRepository.save(TypeEntity);
    }

    // Update unit name or description by unit type ID
    @PutMapping("/{id}")
    public ResponseEntity<TypeEntity> updateTypeEntity(@PathVariable(value = "id") int typesEntityId,  @Valid @RequestBody TypeEntity typesEntityDetails) throws ResourceNotFoundException {
        TypeEntity typesEntity = typeRepository.findById(typesEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("TypeEntity not found for this id :: " + typesEntityId));

        typesEntity.setName(typesEntityDetails.getName());
        typesEntity.setDescription(typesEntityDetails.getDescription());
        final TypeEntity updatedTypeEntity = typeRepository.save(typesEntity);
        return ResponseEntity.ok(updatedTypeEntity);
    }

    // Delete unit type
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteTypeEntity(@PathVariable(value = "id") int typesEntityId)
            throws ResourceNotFoundException {
        TypeEntity TypeEntity = typeRepository.findById(typesEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("TypeEntity not found for this id :: " + typesEntityId));

        typeRepository.delete(TypeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
