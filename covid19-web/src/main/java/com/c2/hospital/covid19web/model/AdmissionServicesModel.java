package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdmissionServicesModel {
    private Integer id;
    private Integer serviceId;
    private Integer admissionId;
    private Date serviceDate;
    private String serviceResult;
    private String description;
    private boolean availableService;
}
