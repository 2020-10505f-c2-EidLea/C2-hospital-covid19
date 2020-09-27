<<<<<<< HEAD
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_TYPES")
@Getter
@Setter
@ToString
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
}
=======
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_TYPES")
@Getter
@Setter
@ToString
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description; // can be normal unit, ICU, CCU, isolated...
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
