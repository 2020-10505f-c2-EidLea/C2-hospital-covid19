<<<<<<< HEAD
package com.c2.hospital.equipmentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_EQUIPMENT_TYPE")
@Getter
@Setter
@ToString
public class EquipmentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
}
=======
package com.c2.hospital.equipmentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_EQUIPMENT_TYPE")
@Getter
@Setter
@ToString
public class EquipmentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int serviceId;
    private String description;
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
