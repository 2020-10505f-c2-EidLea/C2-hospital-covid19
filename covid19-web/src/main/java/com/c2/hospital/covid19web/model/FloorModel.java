package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FloorModel
{
    private int id;
    private String nbr;
    private String bloc;
    private String specialization;
}
