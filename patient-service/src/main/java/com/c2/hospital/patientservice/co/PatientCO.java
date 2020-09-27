<<<<<<< HEAD
package com.c2.hospital.patientservice.co;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class PatientCO {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String result;
    private List<AdmissionCO> admissionList;
}
=======
package com.c2.hospital.patientservice.co;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class PatientCO {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String result;
    private List<AdmissionCO> admissionList;
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
