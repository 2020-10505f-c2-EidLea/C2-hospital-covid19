package com.c2.hospital.covid19web.service;

import com.c2.hospital.covid19web.model.CoronaCountryModel;

import java.util.Map;

public interface CoronaVirusData {

    void setData(String uri);

    Map<String, CoronaCountryModel> getCountryDataMap();

    void setCountryDataMap();

}
