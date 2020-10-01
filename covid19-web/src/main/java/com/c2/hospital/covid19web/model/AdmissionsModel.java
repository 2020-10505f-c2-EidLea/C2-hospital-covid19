package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class AdmissionsModel {
    private Integer id; //historyId
    private Integer nbrOfDays;
    private Date checkIn;
    private Date checkOut;
    private Date serviceDate;

    private Integer profileId;
    private Integer admissionId;
    private Integer serviceId;
    private Integer historyId;
    private Integer floorId;
    private Integer roomClassId;
    private Integer roomTypeId;
    private Integer roomId;
    private String description;
    private String result;
    private String roomInfo;
    private String serviceResult;
    private Integer admissionServiceId;
    private List<AdmissionServicesModel> admissionServicesList;
}
