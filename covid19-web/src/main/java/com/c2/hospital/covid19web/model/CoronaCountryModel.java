package com.c2.hospital.covid19web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CoronaCountryModel {
    private String country;
    private List<CoronaStateModel> stateModelsList = new ArrayList<>();
    private int latestCases;
    private int diffFromPrevDay;
    private boolean updated;
    private Double longitude;
    private Double latitude;
    private int death;
    private int deathDiffFromPrevDay;

}
