package com.c2.hospital.admissionservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_ADMISSION_SERVICE")
@Getter
@Setter
@ToString
public class AdmissionServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int serviceId;
    private int admissionId;
    private Date serviceDate;
    private String serviceResult;
}
