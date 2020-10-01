package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomModel {
    private int id;
    private String nbr;
    private int idType;
    private int idClass;
    private int idFloor;
    private boolean available;
    private int nbrReservedBeds;
    private String classes_name;
    private int classes_nbrOfBed;
    private String floor_nbr;
    private String floor_bloc;
    private String floor_specialization;
    private String type_name;
    private String type_description;
}
