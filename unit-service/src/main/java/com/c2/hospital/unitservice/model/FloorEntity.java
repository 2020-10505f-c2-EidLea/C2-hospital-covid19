<<<<<<< HEAD
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_FLOOR")
@Getter
@Setter
@ToString
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nbr;
    private String bloc;
    private String specialization;
}
=======
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_FLOOR")
@Getter
@Setter
@ToString
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nbr; // code
    private String bloc; // parent section/building
    private String specialization; // medical specialization of each floor
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
