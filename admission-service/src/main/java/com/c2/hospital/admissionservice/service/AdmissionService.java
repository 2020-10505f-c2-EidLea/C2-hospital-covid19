package com.c2.hospital.admissionservice.service;

import com.c2.hospital.admissionservice.co.AdmissionCO;
import com.c2.hospital.admissionservice.exception.ResourceNotFoundException;

public interface AdmissionService {

    AdmissionCO findAdmissionServiceById(int admissionEntityId) throws ResourceNotFoundException;

    AdmissionCO saveAdmission(AdmissionCO admissionCO) throws ResourceNotFoundException;
}
