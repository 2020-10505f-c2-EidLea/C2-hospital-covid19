package com.c2.hospital.admissionservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_ADMISSION")
@Getter
@Setter
@ToString
public class AdmissionEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int nbrOfDays;
    private Date checkIn;
    private Date checkOut;
}
