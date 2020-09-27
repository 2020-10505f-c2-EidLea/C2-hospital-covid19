<<<<<<< HEAD
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ROOM")
@Getter
@Setter
@ToString
public class RoomEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nbr;
    private int idType;
    private int idClass;
    private int idFloor;
    private int isAvailable;
    private int nbrReservedBeds;
}
=======
package com.c2.hospital.unitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ROOM")
@Getter
@Setter
@ToString
public class RoomEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nbr;
    private int idType; // type of room
    private int idClass; // class of room
    private int idFloor; // parent floor
    private boolean available; // is room full or still have free beds
    private int nbrReservedBeds; // number of bed reserved, dependent of type of room & class
}
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
