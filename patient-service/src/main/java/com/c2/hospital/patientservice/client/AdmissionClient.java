package com.c2.hospital.patientservice.client;

import com.c2.hospital.patientservice.co.AdmissionCO;
import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "admission-service" , fallback = AdmissionClientFallBack.class)
public interface AdmissionClient {

	
	@RequestMapping(method = RequestMethod.GET, value = "/admission/{id}" )
	public ResponseEntity<AdmissionCO> getAdmissionEntityById(@RequestParam(value = "id") int admissionEntityId) throws ResourceNotFoundException;

}
