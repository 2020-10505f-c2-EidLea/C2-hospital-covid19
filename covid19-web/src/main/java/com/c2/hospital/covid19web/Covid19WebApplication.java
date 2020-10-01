package com.c2.hospital.covid19web;

import com.c2.hospital.covid19web.service.Covid19Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Covid19WebApplication {

    public static void main(String[] args) {
        GenericApplicationContext context = (GenericApplicationContext) SpringApplication.run(Covid19WebApplication.class, args);
        if(null != context.getEnvironment().getProperty("API_GATEWAY_LINK"))
        {
            Covid19Utils.GATEWAY_URL = context.getEnvironment().getProperty("API_GATEWAY_LINK") + "/api";
        }
        if(null != context.getEnvironment().getProperty("VIRUS_DATA_URL"))
        {
            Covid19Utils.VIRUS_DATA_URL = context.getEnvironment().getProperty("VIRUS_DATA_URL");
        }
        if(null != context.getEnvironment().getProperty("DEATH_DATA_URL"))
        {
            Covid19Utils.DEATH_DATA_URL = context.getEnvironment().getProperty("DEATH_DATA_URL");
        }
    }

}
