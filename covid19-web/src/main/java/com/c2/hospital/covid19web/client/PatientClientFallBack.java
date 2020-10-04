package com.c2.hospital.covid19web.client;

import com.c2.hospital.covid19web.exception.ResourceNotFoundException;
import com.c2.hospital.covid19web.model.AdmissionsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PatientClientFallBack implements PatientClient {

	/**
	 * @return  empty if the Admission-service -> getAdmissionEntityById microservice fails for some reason or its down
	 */
	public ResponseEntity<AdmissionsModel> getAdmissionEntityById(int admissionEntityId) throws ResourceNotFoundException
	{
		System.out.println(" Warning :  Using fallback method for AdmissionClient -> getAdmissionEntityById");
		return ResponseEntity.ok().body(new AdmissionsModel());
	}

}
