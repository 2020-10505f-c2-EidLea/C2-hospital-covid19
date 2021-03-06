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

    @Column(nullable = true)
    private Integer roomId;
    private Date checkIn;

    @Column(nullable = true)
    private Date checkOut;
}
