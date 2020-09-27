<<<<<<< HEAD
package com.c2.hospital.patientservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_HISTORY")
@Getter
@Setter
@ToString
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int profileId;
    private int admissionId;
    private String description;
    private String result;
}
=======
package com.c2.hospital.patientservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_HISTORY")
@Getter
@Setter
@ToString
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int profileId;
    private int admissionId;
    private String description;
    private String result;
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
