package com.c2.hospital.patientservice.service.impl;

import com.c2.hospital.patientservice.client.AdmissionClient;
import com.c2.hospital.patientservice.co.AdmissionCO;
import com.c2.hospital.patientservice.co.PatientCO;
import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import com.c2.hospital.patientservice.model.HistoryEntity;
import com.c2.hospital.patientservice.model.ProfileEntity;
import com.c2.hospital.patientservice.repository.HistoryRepository;
import com.c2.hospital.patientservice.repository.ProfileRepository;
import com.c2.hospital.patientservice.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AdmissionClient admissionClient;

    @Override
    public PatientCO getHistoryByPatient(int profileEntityId) throws ResourceNotFoundException {
        PatientCO patientCO = null;
        ProfileEntity profile = profileRepository.findById(profileEntityId).get();
        if(null != profile)
        {
            patientCO = new PatientCO();
            patientCO.setAdmissionList(new ArrayList<>());
            BeanUtils.copyProperties(profile, patientCO);
            List<HistoryEntity> historyList = historyRepository.findHistoryByProfileId(profileEntityId);
            for (HistoryEntity historyEntity: historyList)
            {
                ResponseEntity<AdmissionCO> response = admissionClient.getAdmissionEntityById(historyEntity.getAdmissionId());
                AdmissionCO admissionCO = response.getBody();
                BeanUtils.copyProperties(historyEntity, admissionCO);
                patientCO.getAdmissionList().add(admissionCO);
            }
        }
        return patientCO;
    }

    @Override
    public PatientCO getResultByPatient(int profileEntityId) {
        PatientCO patientCO = null;
        ProfileEntity profile = profileRepository.findById(profileEntityId).get();
        if(null != profile)
        {
            patientCO = new PatientCO();
            BeanUtils.copyProperties(profile, patientCO);
            List<HistoryEntity> historyList = historyRepository.findHistoryByProfileId(profileEntityId);
            historyList.sort(Comparator.comparing(HistoryEntity::getId).reversed());
            historyList = historyList.stream().sorted(Comparator.comparing(HistoryEntity::getId).reversed()).collect(Collectors.toList());
            patientCO.setResult(historyList.get(0).getResult());
            patientCO.setDescription(historyList.get(0).getDescription());
        }
        return patientCO;
    }
}
