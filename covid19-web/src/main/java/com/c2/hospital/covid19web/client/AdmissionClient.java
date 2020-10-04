package com.c2.hospital.covid19web.client;

import com.c2.hospital.covid19web.exception.ResourceNotFoundException;
import com.c2.hospital.covid19web.model.AdmissionsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "admission-service" , fallback = AdmissionClientFallBack.class)
public interface AdmissionClient {

	
	@RequestMapping(method = RequestMethod.GET, value = "/admission/{id}" )
	public ResponseEntity<AdmissionsModel> getAdmissionEntityById(@RequestParam(value = "id") int admissionEntityId) throws ResourceNotFoundException;

}
