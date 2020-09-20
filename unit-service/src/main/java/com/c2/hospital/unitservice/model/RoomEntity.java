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
    private boolean available;
    private int nbrReservedBeds;
}
