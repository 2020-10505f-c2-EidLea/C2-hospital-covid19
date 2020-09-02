package com.project_C2.microservices.services.patients;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.project_C2.microservices.patient.PatientConfiguration;
import com.project_C2.microservices.patient.PatientRepository;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * 
 * @author Micehl IBRAHIM
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import(PatientConfiguration.class)
public class PatientsServer {

	@Autowired
	protected PatientRepository patientRepository;

	protected Logger logger = Logger.getLogger(PatientsServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for patients-server.properties
		System.setProperty("spring.config.name", "patients-server");

		SpringApplication.run(PatientsServer.class, args);
	}
}
