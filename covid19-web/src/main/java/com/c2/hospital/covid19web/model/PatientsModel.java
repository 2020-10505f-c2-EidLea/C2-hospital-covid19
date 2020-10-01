package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class PatientsModel {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String result;
    private String searchBy;
    private List<AdmissionsModel> admissionList;
}
