package com.c2.hospital.covid19web.service.impl;

import com.c2.hospital.covid19web.model.AdmissionsModel;
import com.c2.hospital.covid19web.model.PatientsModel;
import com.c2.hospital.covid19web.service.Covid19Utils;
import com.c2.hospital.covid19web.service.PatientsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientsServiceImpl implements PatientsService {
    @Override
    public void deleteById(Integer patientId) throws Exception
    {
        Covid19Utils.deleteData("/patients/profile/"+patientId);
    }

    @Override
    public void save(PatientsModel patient) throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(patient);
        Covid19Utils.putData("/patients/profile/"+patient.getId(), json);
    }

    @Override
    public void saveNew(PatientsModel patient) throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(patient);
        Covid19Utils.postData("/patients/profile/", json);

    }

    @Override
    public PatientsModel findById(Integer patientId) throws Exception
    {
        PatientsModel patient = null;
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonObject = new JSONObject(Covid19Utils.fetchData("/patients/profile/"+patientId));
        patient = objectMapper.readValue(jsonObject.toString(), PatientsModel.class);
        return patient;
    }

    @Override
    public PatientsModel returnPatientAdmissionById(Integer patientId) throws Exception
    {
        PatientsModel patient = null;
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonObject = new JSONObject(Covid19Utils.fetchData("/patients/profile/"+patientId+"/history"));
        patient = objectMapper.readValue(jsonObject.toString(), PatientsModel.class);
        return patient;
    }

    @Override
    public List<PatientsModel> getList() throws Exception
    {
        List<PatientsModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/patients/profile/"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            PatientsModel patient = objectMapper.readValue(jsonObject.toString(), PatientsModel.class);
            lst.add(patient);
        }
        return lst;
    }

    @Override
    public PatientsModel getPatientHistory(int patientId) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Covid19Utils.fetchData("/patients/profile/"+patientId+"/history").toString(), PatientsModel.class);
    }

    public AdmissionsModel updatePatientHistory(AdmissionsModel admissionsModel) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(admissionsModel);
        String str = Covid19Utils.putData("/patients/history/"+admissionsModel.getId(), json);
        return admissionsModel;
    }


}
