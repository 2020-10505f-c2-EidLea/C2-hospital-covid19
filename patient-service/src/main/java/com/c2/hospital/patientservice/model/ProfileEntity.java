package com.c2.hospital.patientservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_PROFILE")
@Getter
@Setter
@ToString
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String gender;
    private String address;
    private String phone;
    private String email;
}
