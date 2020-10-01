package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoronaStateModel {
    private String state;
    private int latestCases;
    private int diffFromPrevDay;
    private boolean updated;
    private Double longitude;
    private Double latitude;
    private int death;

}
