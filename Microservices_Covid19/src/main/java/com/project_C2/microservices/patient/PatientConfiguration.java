package com.project_C2.microservices.patient;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The patients Spring configuration.
 * 
 * @author Michel Ibrahim
 */
@Configuration
@ComponentScan
@EntityScan("io.pivotal.microservices.accounts")
@EnableJpaRepositories("io.pivotal.microservices.accounts")
@PropertySource("classpath:db-config.properties")
public class PatientConfiguration {
	
	protected Logger logger;

	public PatientConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

}
