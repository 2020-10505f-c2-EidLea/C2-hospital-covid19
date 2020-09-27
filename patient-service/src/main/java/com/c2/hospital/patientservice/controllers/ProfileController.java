<<<<<<< HEAD
package com.c2.hospital.patientservice.controllers;

import com.c2.hospital.patientservice.co.PatientCO;
import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import com.c2.hospital.patientservice.model.ProfileEntity;
import com.c2.hospital.patientservice.repository.ProfileRepository;
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
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/")
    public List<ProfileEntity> getAllProfileEntitys() {
        return profileRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileEntity> getProfileEntityById(@PathVariable(value = "id") int profileEntityId) throws ResourceNotFoundException {
        ProfileEntity ProfileEntity = profileRepository.findById(profileEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));
        return ResponseEntity.ok().body(ProfileEntity);
    }

    @PostMapping("/")
    public ProfileEntity createProfileEntity(@Valid @RequestBody ProfileEntity ProfileEntity) {
        return profileRepository.save(ProfileEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileEntity> updateProfileEntity(@PathVariable(value = "id") int profileEntityId,  @Valid @RequestBody ProfileEntity profileEntityDetails) throws ResourceNotFoundException {
        ProfileEntity profileEntity = profileRepository.findById(profileEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));

        profileEntity.setFirstName(profileEntityDetails.getFirstName());
        profileEntity.setMiddleName(profileEntityDetails.getMiddleName());
        profileEntity.setLastName(profileEntityDetails.getLastName());
        profileEntity.setBirthdate(profileEntityDetails.getBirthdate());
        profileEntity.setGender(profileEntityDetails.getGender());
        profileEntity.setAddress(profileEntityDetails.getAddress());
        profileEntity.setPhone(profileEntityDetails.getPhone());
        profileEntity.setEmail(profileEntityDetails.getEmail());
        final ProfileEntity updatedProfileEntity = profileRepository.save(profileEntity);
        return ResponseEntity.ok(updatedProfileEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProfileEntity(@PathVariable(value = "id") int profileEntityId)
            throws ResourceNotFoundException {
        ProfileEntity ProfileEntity = profileRepository.findById(profileEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));

        profileRepository.delete(ProfileEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<PatientCO> getHistoryByPatient(@PathVariable(value = "id") int profileEntityId) throws ResourceNotFoundException {
        PatientCO patientCO = Optional.ofNullable(patientService.getHistoryByPatient(profileEntityId))
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));
        if(null == patientCO)
        {
            throw new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId);
        }
        return ResponseEntity.ok().body(patientCO);
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<PatientCO> getResultByPatient(@PathVariable(value = "id") int profileEntityId) throws ResourceNotFoundException {
        PatientCO patientCO = Optional.ofNullable(patientService.getResultByPatient(profileEntityId))
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));
        if(null == patientCO)
        {
            throw new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId);
        }
        return ResponseEntity.ok().body(patientCO);
    }
}
=======
package com.c2.hospital.patientservice.controllers;

import com.c2.hospital.patientservice.co.PatientCO;
import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import com.c2.hospital.patientservice.model.ProfileEntity;
import com.c2.hospital.patientservice.repository.ProfileRepository;
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
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/")
    public List<ProfileEntity> getAllProfileEntitys() {
        return profileRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileEntity> getProfileEntityById(@PathVariable(value = "id") int profileEntityId) throws ResourceNotFoundException {
        ProfileEntity ProfileEntity = profileRepository.findById(profileEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));
        return ResponseEntity.ok().body(ProfileEntity);
    }

    @PostMapping("/")
    public ProfileEntity createProfileEntity(@Valid @RequestBody ProfileEntity ProfileEntity) {
        return profileRepository.save(ProfileEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileEntity> updateProfileEntity(@PathVariable(value = "id") int profileEntityId,  @Valid @RequestBody ProfileEntity profileEntityDetails) throws ResourceNotFoundException {
        ProfileEntity profileEntity = profileRepository.findById(profileEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));

        profileEntity.setFirstName(profileEntityDetails.getFirstName());
        profileEntity.setMiddleName(profileEntityDetails.getMiddleName());
        profileEntity.setLastName(profileEntityDetails.getLastName());
        profileEntity.setBirthdate(profileEntityDetails.getBirthdate());
        profileEntity.setGender(profileEntityDetails.getGender());
        profileEntity.setAddress(profileEntityDetails.getAddress());
        profileEntity.setPhone(profileEntityDetails.getPhone());
        profileEntity.setEmail(profileEntityDetails.getEmail());
        final ProfileEntity updatedProfileEntity = profileRepository.save(profileEntity);
        return ResponseEntity.ok(updatedProfileEntity);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProfileEntity(@PathVariable(value = "id") int profileEntityId)
            throws ResourceNotFoundException {
        ProfileEntity ProfileEntity = profileRepository.findById(profileEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));

        profileRepository.delete(ProfileEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<PatientCO> getHistoryByPatient(@PathVariable(value = "id") int profileEntityId) throws ResourceNotFoundException {
        PatientCO patientCO = Optional.ofNullable(patientService.getHistoryByPatient(profileEntityId))
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));
        if(null == patientCO)
        {
            throw new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId);
        }
        return ResponseEntity.ok().body(patientCO);
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<PatientCO> getResultByPatient(@PathVariable(value = "id") int profileEntityId) throws ResourceNotFoundException {
        PatientCO patientCO = Optional.ofNullable(patientService.getResultByPatient(profileEntityId))
                .orElseThrow(() -> new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId));
        if(null == patientCO)
        {
            throw new ResourceNotFoundException("ProfileEntity not found for this id :: " + profileEntityId);
        }
        return ResponseEntity.ok().body(patientCO);
    }
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
