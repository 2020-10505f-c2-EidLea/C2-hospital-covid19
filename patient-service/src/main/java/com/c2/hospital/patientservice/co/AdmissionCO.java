<<<<<<< HEAD
package com.c2.hospital.patientservice.co;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AdmissionCO {
    private int id; //historyId
    private int nbrOfDays;
    private Date checkIn;
    private Date checkOut;

    private int profileId;
    private int admissionId;
    private String description;
    private String result;
}
=======
package com.c2.hospital.patientservice.co;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AdmissionCO {
    private int id; //historyId
    private int nbrOfDays;
    private Date checkIn;
    private Date checkOut;

    private int profileId;
    private int admissionId;
    private String description;
    private String result;
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
