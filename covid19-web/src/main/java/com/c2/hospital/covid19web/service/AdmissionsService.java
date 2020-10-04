package com.c2.hospital.covid19web.service;

import com.c2.hospital.covid19web.model.*;

import java.util.List;

public interface AdmissionsService {

    List<AdmissionsModel> getList() throws Exception;

    List<ServicesModel> getServiceList() throws Exception;

    List<RoomTypeModel> getRoomTypeList()  throws Exception;

    List<FloorModel> getFloorList()  throws Exception;

    List<RoomClassesModel> getRoomClassesList() throws Exception;

    ServicesModel serviceValidation(int serviceId) throws Exception;

    AdmissionsModel profileValidation(int profileId) throws Exception;

    AdmissionsModel endPatientAdmission(AdmissionsModel admissionsModel) throws Exception;

    public List<RoomModel> roomValidation(int floorId, int typeId, int classId) throws Exception;

    RoomModel roomIdValidation(int roomId) throws Exception;

    AdmissionsModel returnAdmissionServicesById(int admissionId) throws Exception;

    AdmissionsModel save(AdmissionsModel admission)throws Exception;
}
