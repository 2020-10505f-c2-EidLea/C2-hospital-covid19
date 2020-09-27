package com.c2.hospital.admissionservice.co;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdmissionServicesCO {
    private int id;
    private int serviceId;
    private int admissionId;
    private Date serviceDate;
    private String serviceResult;
    private String description;
    private boolean availableService;
}
