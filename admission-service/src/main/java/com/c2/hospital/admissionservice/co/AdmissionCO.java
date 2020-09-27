package com.c2.hospital.admissionservice.co;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AdmissionCO {
    private int id;
    private int nbrOfDays;
    private Integer roomId;
    private Date checkIn;
    private Date checkOut;
    private Integer serviceId;
    private Date serviceDate;
    private String serviceResult;
    private Integer admissionServiceId;

    List<AdmissionServicesCO> admissionServicesList;
}
