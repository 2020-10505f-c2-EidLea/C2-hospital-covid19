<<<<<<< HEAD
package com.c2.hospital.equipmentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PROVIDER")
@Getter
@Setter
@ToString
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
}
=======
package com.c2.hospital.equipmentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PROVIDER")
@Getter
@Setter
@ToString
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
