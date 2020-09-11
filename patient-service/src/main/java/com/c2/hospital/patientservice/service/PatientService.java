package com.c2.hospital.patientservice.service;

import com.c2.hospital.patientservice.co.PatientCO;
import com.c2.hospital.patientservice.exception.ResourceNotFoundException;

public interface PatientService {

    PatientCO getHistoryByPatient(int profileEntityId) throws ResourceNotFoundException;

    PatientCO getResultByPatient(int profileEntityId);
}
