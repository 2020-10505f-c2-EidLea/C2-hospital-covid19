<<<<<<< HEAD
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CLASSES")
@Getter
@Setter
@ToString
public class ClassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int nbrOfBed;
}
=======
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CLASSES")
@Getter
@Setter
@ToString
public class ClassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int nbrOfBed; // class A = 1 bed, class B = 2 beds, ...
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
