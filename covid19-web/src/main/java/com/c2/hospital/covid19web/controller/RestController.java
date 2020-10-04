package com.c2.hospital.covid19web.controller;

import com.c2.hospital.covid19web.model.AdmissionsModel;
import com.c2.hospital.covid19web.model.RoomModel;
import com.c2.hospital.covid19web.model.ServicesModel;
import com.c2.hospital.covid19web.service.AdmissionsService;
import com.c2.hospital.covid19web.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/covid19")
public class RestController {

	@Autowired
	PatientsService patientsService;

	@Autowired
	AdmissionsService admissionsService;

	@GetMapping("/profile/validation/{id}")
	public ResponseEntity<AdmissionsModel> profileValidation(@PathVariable(value = "id") int profileId) throws Exception {
		AdmissionsModel AdmissionEntity = admissionsService.profileValidation(profileId);
		return ResponseEntity.ok().body(AdmissionEntity);
	}

	@GetMapping("/service/validation/{id}")
	public ResponseEntity<ServicesModel> serviceValidation(@PathVariable(value = "id") int serviceId) throws Exception {
		ServicesModel servicesModel = admissionsService.serviceValidation(serviceId);
		return ResponseEntity.ok().body(servicesModel);
	}

	@GetMapping("/room/validation/{floorId}/{typeId}/{classId}")
	public ResponseEntity<List<RoomModel>> roomValidation(@PathVariable(value = "floorId") int floorId, @PathVariable(value = "typeId") int typeId, @PathVariable(value = "classId") int classId) throws Exception {
		List<RoomModel> roomModelList = admissionsService.roomValidation(floorId, typeId, classId);
		return ResponseEntity.ok().body(roomModelList);
	}

	@GetMapping("/roomId/validation/{roomId}")
	public ResponseEntity<RoomModel> roomValidation(@PathVariable(value = "roomId") int roomId) throws Exception {
		RoomModel roomModel = admissionsService.roomIdValidation(roomId);
		return ResponseEntity.ok().body(roomModel);
	}

	@GetMapping("/admission/{admissionId}/end/{historyId}/{result}")
	public ResponseEntity<AdmissionsModel> endPatientAdmission(@PathVariable(value = "admissionId") int admissionId,
															   @PathVariable(value = "historyId") int historyId,
															   @PathVariable(value = "result") String result) throws Exception
	{

		AdmissionsModel admissionsModel = new AdmissionsModel();
		admissionsModel.setId(admissionId);
		admissionsModel.setHistoryId(historyId);
		admissionsModel.setCheckOut(new Date());
		admissionsModel.setResult(result);
		admissionsService.endPatientAdmission(admissionsModel);
		return ResponseEntity.ok().body(admissionsModel);
	}

	@GetMapping("/admission/{admissionId}/services")
	public ResponseEntity<AdmissionsModel> returnAdmissionServicesById(@PathVariable(value = "admissionId") int admissionId) throws Exception {
		AdmissionsModel admissionsModel = admissionsService.returnAdmissionServicesById(admissionId);
		return ResponseEntity.ok().body(admissionsModel);
	}
}
