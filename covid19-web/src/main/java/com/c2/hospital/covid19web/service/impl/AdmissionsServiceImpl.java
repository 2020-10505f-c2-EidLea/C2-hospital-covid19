package com.c2.hospital.covid19web.service.impl;

import com.c2.hospital.covid19web.exception.ResourceNotFoundException;
import com.c2.hospital.covid19web.model.*;
import com.c2.hospital.covid19web.service.AdmissionsService;
import com.c2.hospital.covid19web.service.Covid19Utils;
import com.c2.hospital.covid19web.service.PatientsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdmissionsServiceImpl implements AdmissionsService
{
    @Autowired
    PatientsService patientsService;


    @Override
    public List<AdmissionsModel> getList() throws Exception
    {
        List<AdmissionsModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/admissions/admissions"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            AdmissionsModel emp = objectMapper.readValue(jsonObject.toString(), AdmissionsModel.class);
            lst.add(emp);
        }
        return lst;
    }

    @Override
    public List<ServicesModel> getServiceList()  throws Exception
    {
        List<ServicesModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/admissions/services/"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            ServicesModel servicesModel = objectMapper.readValue(jsonObject.toString(), ServicesModel.class);
            lst.add(servicesModel);
        }
        return lst;
    }

    @Override
    public List<RoomTypeModel> getRoomTypeList()  throws Exception
    {
        List<RoomTypeModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/units/types/"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            RoomTypeModel roomTypeModel = objectMapper.readValue(jsonObject.toString(), RoomTypeModel.class);
            lst.add(roomTypeModel);
        }
        return lst;
    }

    @Override
    public List<FloorModel> getFloorList()  throws Exception
    {
        List<FloorModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/units/floor/"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            FloorModel floorModel = objectMapper.readValue(jsonObject.toString(), FloorModel.class);
            lst.add(floorModel);
        }
        return lst;
    }

    @Override
    public List<RoomClassesModel> getRoomClassesList()  throws Exception
    {
        List<RoomClassesModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/units/class/"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            RoomClassesModel roomClassesModel = objectMapper.readValue(jsonObject.toString(), RoomClassesModel.class);
            lst.add(roomClassesModel);
        }
        return lst;
    }

    @Override
    public AdmissionsModel endPatientAdmission(AdmissionsModel admissionsModel) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(admissionsModel);
        String str = Covid19Utils.putData("/admissions/admission/"+admissionsModel.getId(), json);

        admissionsModel.setId(admissionsModel.getHistoryId());
        patientsService.updatePatientHistory(admissionsModel);

        return admissionsModel;
    }

    @Override
    public ServicesModel serviceValidation(int serviceId) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ServicesModel servicesModel = objectMapper.readValue(Covid19Utils.fetchData("/admissions/services/"+serviceId), ServicesModel.class);
        servicesModel.setEquipmentList(new ArrayList<>());
        if(serviceId == 1 || serviceId == 2) //Test Covid19, In Hospital
        {
            List<EquipmentModel> lst = servicesModel.getEquipmentList();
            JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/equipments/equipment/service/"+serviceId+"/info"));
            for (Object objVar: jsonArray) {
                JSONObject jsonObject = (JSONObject)objVar;
                EquipmentModel equipmentModel = objectMapper.readValue(jsonObject.toString(), EquipmentModel.class);
                lst.add(equipmentModel);
            }
        }
        return servicesModel;
    }

    @Override
    public AdmissionsModel profileValidation(int profileId) throws Exception {
        PatientsModel patientsModel = patientsService.returnPatientAdmissionById(profileId);
        Optional<AdmissionsModel> admissionsModel = patientsModel.getAdmissionList().stream().filter(e -> null == e.getCheckOut()).findFirst();
        return admissionsModel.isPresent()?admissionsModel.get():new AdmissionsModel();
    }

    @Override
    public List<RoomModel> roomValidation(int floorId, int typeId, int classId) throws Exception
    {
        List<RoomModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/units/room/available"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            RoomModel roomModel = objectMapper.readValue(jsonObject.toString(), RoomModel.class);
            lst.add(roomModel);
        }
        if(0 != floorId)
        {
            lst = lst.stream().filter(e -> e.getIdFloor() == floorId).collect(Collectors.toList());
        }
        if(0 != typeId)
        {
            lst = lst.stream().filter(e -> e.getIdType() == typeId).collect(Collectors.toList());
        }
        if(0 != classId)
        {
            lst = lst.stream().filter(e -> e.getIdClass() == classId).collect(Collectors.toList());
        }
        return lst;
    }

    @Override
    public RoomModel roomIdValidation(int roomId) throws Exception {
        List<RoomModel> lst = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray jsonArray = new JSONArray(Covid19Utils.fetchData("/units/room/available"));
        for (Object objVar: jsonArray) {
            JSONObject jsonObject = (JSONObject)objVar;
            RoomModel roomModel = objectMapper.readValue(jsonObject.toString(), RoomModel.class);
            lst.add(roomModel);
        }
        Optional<RoomModel> roomModel = lst.stream().filter(e -> e.getId() == roomId).findFirst();
        return roomModel.isPresent()?roomModel.get():new RoomModel();
    }

    @Override
    public AdmissionsModel returnAdmissionServicesById(int admissionId) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonObject = new JSONObject(Covid19Utils.fetchData("/admissions/admission/"+admissionId+"/services"));
        AdmissionsModel admissionsModel = objectMapper.readValue(jsonObject.toString(), AdmissionsModel.class);
        if(null != admissionsModel.getRoomId() && 0 != admissionsModel.getRoomId())
        {
            JSONObject roomDetailsObject = new JSONObject(Covid19Utils.fetchData("/units/room/"+admissionsModel.getRoomId()+"/info"));
            RoomModel roomModel = objectMapper.readValue(roomDetailsObject.toString(), RoomModel.class);
            if (roomModel == null) {
                throw new ResourceNotFoundException("service not found for this id :: " + roomModel.getId());
            }
            admissionsModel.setRoomInfo("Room No: " + roomModel.getNbr()+"- Class : " + roomModel.getClasses_name() + " - Floor :" + roomModel.getFloor_bloc() + " - " + roomModel.getFloor_specialization());
        }
        return admissionsModel;
    }

    @Override
    public AdmissionsModel save(AdmissionsModel admission) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PatientsModel patientsModel = patientsService.returnPatientAdmissionById(admission.getProfileId());
        if(patientsModel == null)
        {
            throw new ResourceNotFoundException("patients not found for this id : " + admission.getProfileId());
        }

        ServicesModel servicesModel = serviceValidation(admission.getServiceId());
        if(servicesModel == null)
        {
            throw new ResourceNotFoundException("service not found for this id : " + admission.getServiceId());
        }

        if((admission.getServiceId() == 2 || admission.getServiceId() ==3) && (admission.getRoomId() == null || 0 == admission.getRoomId()))
        {
            throw new ResourceNotFoundException("Missing Room Id for this service : " + servicesModel.getDescription());
        }

        if(admission.getServiceId() != 3)
        {
            Optional<EquipmentModel> optional = servicesModel.getEquipmentList().stream().filter(e-> e.getDisponibility() > 0).findFirst();
            if(optional.isPresent())
            {
                EquipmentModel roomModelResult = objectMapper.readValue(Covid19Utils.fetchData("/equipments/equipment/"+optional.get().getId()+"/consume/1"), EquipmentModel.class);
                System.out.println(roomModelResult);
            }
            else
            {
                throw new ResourceNotFoundException("No Quantity Available to proceed with service  : " + servicesModel.getDescription());
            }
        }

        if(null != admission.getRoomId())
        {
            RoomModel roomModel = roomIdValidation(admission.getRoomId());
            if (roomModel == null) {
                throw new ResourceNotFoundException("service not found for this id :: " + admission.getServiceId());
            }
            RoomModel roomModelResult = objectMapper.readValue(Covid19Utils.fetchData("/units/room/"+admission.getRoomId()+"/reserve"), RoomModel.class);
        }

        String json = objectMapper.writeValueAsString(admission);
        AdmissionsModel admissionResult = objectMapper.readValue(Covid19Utils.postData("/admissions/admission/save", json), AdmissionsModel.class);
        admission.setId(admissionResult.getId());
        admission.setAdmissionServiceId(admissionResult.getAdmissionServiceId());

        PatientsModel patientsModel1= patientsService.getPatientHistory(patientsModel.getId());
        Optional optional = patientsModel1.getAdmissionList().stream().filter(e -> e.getAdmissionId() == admission.getId()).findFirst();

        if(!optional.isPresent())
        {
            AdmissionsModel history = new AdmissionsModel();
            history.setProfileId(admission.getProfileId());
            history.setAdmissionId(admissionResult.getId());
            history.setDescription(admission.getDescription());
            history = objectMapper.readValue(Covid19Utils.postData("/patients/history/", objectMapper.writeValueAsString(history)), AdmissionsModel.class);
        }

        //update service qty

        return admission;
    }


}
