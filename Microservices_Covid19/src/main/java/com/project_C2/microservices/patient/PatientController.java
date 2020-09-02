package com.project_C2.microservices.patient;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RestController;



/**
 * A RESTFul controller for accessing patient information.
 * 
 * @author Paul Chapman
 */
@RestController
public class PatientController {

	protected Logger logger = Logger.getLogger(PatientController.class
			.getName());
	protected PatientRepository patientRepository;
	
	
	
}
