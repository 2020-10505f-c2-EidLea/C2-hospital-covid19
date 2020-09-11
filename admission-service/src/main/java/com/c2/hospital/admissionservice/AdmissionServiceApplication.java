package com.c2.hospital.admissionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class AdmissionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmissionServiceApplication.class, args);
    }

}
