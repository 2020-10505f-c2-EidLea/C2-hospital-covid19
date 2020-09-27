<<<<<<< HEAD
package com.c2.hospital.patientservice.controllers;

import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import com.c2.hospital.patientservice.model.HistoryEntity;
import com.c2.hospital.patientservice.repository.HistoryRepository;
import com.c2.hospital.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/")
    public List<HistoryEntity> getAllHistoryEntitys() {
        return historyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryEntity> getHistoryEntityById(@PathVariable(value = "id") int historyEntityId) throws ResourceNotFoundException {
        HistoryEntity HistoryEntity = historyRepository.findById(historyEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("HistoryEntity not found for this id :: " + historyEntityId));
        return ResponseEntity.ok().body(HistoryEntity);
    }

    @PostMapping("/")
    public HistoryEntity createHistoryEntity(@Valid @RequestBody HistoryEntity HistoryEntity) {
        return historyRepository.save(HistoryEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoryEntity> updateHistoryEntity(@PathVariable(value = "id") int historyEntityId,  @Valid @RequestBody HistoryEntity historyEntityDetails) throws ResourceNotFoundException {
        HistoryEntity historyEntity = historyRepository.findById(historyEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("HistoryEntity not found for this id :: " + historyEntityId));

        historyEntity.setProfileId(historyEntityDetails.getProfileId());
        historyEntity.setAdmissionId(historyEntityDetails.getAdmissionId());
        historyEntity.setDescription(historyEntityDetails.getDescription());
        historyEntity.setResult(historyEntityDetails.getResult());
        final HistoryEntity updatedHistoryEntity = historyRepository.save(historyEntity);
        return ResponseEntity.ok(updatedHistoryEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteHistoryEntity(@PathVariable(value = "id") int historyEntityId)
            throws ResourceNotFoundException {
        HistoryEntity HistoryEntity = historyRepository.findById(historyEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("HistoryEntity not found for this id :: " + historyEntityId));

        historyRepository.delete(HistoryEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
=======
package com.c2.hospital.patientservice.controllers;

import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import com.c2.hospital.patientservice.model.HistoryEntity;
import com.c2.hospital.patientservice.repository.HistoryRepository;
import com.c2.hospital.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/")
    public List<HistoryEntity> getAllHistoryEntitys() {
        return historyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryEntity> getHistoryEntityById(@PathVariable(value = "id") int historyEntityId) throws ResourceNotFoundException {
        HistoryEntity HistoryEntity = historyRepository.findById(historyEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("HistoryEntity not found for this id :: " + historyEntityId));
        return ResponseEntity.ok().body(HistoryEntity);
    }

    @PostMapping("/")
    public HistoryEntity createHistoryEntity(@Valid @RequestBody HistoryEntity HistoryEntity) {
        return historyRepository.save(HistoryEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoryEntity> updateHistoryEntity(@PathVariable(value = "id") int historyEntityId,  @Valid @RequestBody HistoryEntity historyEntityDetails) throws ResourceNotFoundException {
        HistoryEntity historyEntity = historyRepository.findById(historyEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("HistoryEntity not found for this id :: " + historyEntityId));

        historyEntity.setProfileId(historyEntityDetails.getProfileId());
        historyEntity.setAdmissionId(historyEntityDetails.getAdmissionId());
        historyEntity.setDescription(historyEntityDetails.getDescription());
        historyEntity.setResult(historyEntityDetails.getResult());
        final HistoryEntity updatedHistoryEntity = historyRepository.save(historyEntity);
        return ResponseEntity.ok(updatedHistoryEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteHistoryEntity(@PathVariable(value = "id") int historyEntityId)
            throws ResourceNotFoundException {
        HistoryEntity HistoryEntity = historyRepository.findById(historyEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("HistoryEntity not found for this id :: " + historyEntityId));

        historyRepository.delete(HistoryEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
