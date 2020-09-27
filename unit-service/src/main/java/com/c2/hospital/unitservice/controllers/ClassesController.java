package com.c2.hospital.unitservice.controllers;

import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.ClassesEntity;
import com.c2.hospital.unitservice.repository.ClassesRepository;
import com.c2.hospital.unitservice.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class ClassesController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private ClassesRepository classesRepository;

    // Get list of all unit classes
    @GetMapping("/")
    public List<ClassesEntity> getAllClassesEntitys() {
        return classesRepository.findAll();
    }

    // Get unit class by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassesEntity> getClassesEntityById(@PathVariable(value = "id") int classesEntityId) throws ResourceNotFoundException {
        ClassesEntity ClassesEntity = classesRepository.findById(classesEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ClassesEntity not found for this id :: " + classesEntityId));
        return ResponseEntity.ok().body(ClassesEntity);
    }

    // Add new unit class
    @PostMapping("/")
    public ClassesEntity createClassesEntity(@Valid @RequestBody ClassesEntity ClassesEntity) {
        return classesRepository.save(ClassesEntity);
    }

    // Update name or reserved beds quantity by unit class ID
    @PutMapping("/{id}")
    public ResponseEntity<ClassesEntity> updateClassesEntity(@PathVariable(value = "id") int classesEntityId,  @Valid @RequestBody ClassesEntity classesEntityDetails) throws ResourceNotFoundException {
        ClassesEntity classesEntity = classesRepository.findById(classesEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ClassesEntity not found for this id :: " + classesEntityId));

        classesEntity.setName(classesEntityDetails.getName());
        classesEntity.setNbrOfBed(classesEntityDetails.getNbrOfBed());
        final ClassesEntity updatedClassesEntity = classesRepository.save(classesEntity);
        return ResponseEntity.ok(updatedClassesEntity);
    }

    // Delete unit class by ID
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteClassesEntity(@PathVariable(value = "id") int classesEntityId)
            throws ResourceNotFoundException {
        ClassesEntity classesEntity = classesRepository.findById(classesEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ClassesEntity not found for this id :: " + classesEntityId));

        classesRepository.delete(classesEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
