package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomClassesModel
{
    private int id;
    private String name;
    private int nbrOfBed;
}
