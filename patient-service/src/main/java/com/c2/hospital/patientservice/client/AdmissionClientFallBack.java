package com.c2.hospital.patientservice.client;

import com.c2.hospital.patientservice.co.AdmissionCO;
import com.c2.hospital.patientservice.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AdmissionClientFallBack implements AdmissionClient {

	/**
	 * @return  empty if the Admission-service -> getAdmissionEntityById microservice fails for some reason or its down
	 */
	public ResponseEntity<AdmissionCO> getAdmissionEntityById(int admissionEntityId) throws ResourceNotFoundException
	{
		System.out.println(" Warning :  Using fallback method for AdmissionClient -> getAdmissionEntityById");
		return ResponseEntity.ok().body(new AdmissionCO());
	}

}
