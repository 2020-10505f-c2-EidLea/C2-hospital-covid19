package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ServicesModel {
    private int id;
    private String description;
    private boolean availableService;
    private List<EquipmentModel> equipmentList;
}
