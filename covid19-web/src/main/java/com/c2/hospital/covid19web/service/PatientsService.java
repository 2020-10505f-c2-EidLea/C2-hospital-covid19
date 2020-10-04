package com.c2.hospital.covid19web.service;

import com.c2.hospital.covid19web.model.AdmissionsModel;
import com.c2.hospital.covid19web.model.PatientsModel;

import java.util.List;

public interface PatientsService {

    void deleteById(Integer patientId) throws Exception;

    void save(PatientsModel patient) throws Exception;

    void saveNew(PatientsModel patient) throws Exception;

    PatientsModel findById(Integer patientId) throws Exception;

    PatientsModel returnPatientAdmissionById(Integer patientId) throws Exception;

    List<PatientsModel> getList() throws Exception;

    PatientsModel getPatientHistory(int patientId) throws Exception;

    AdmissionsModel updatePatientHistory(AdmissionsModel admissionsModel) throws Exception;
}
