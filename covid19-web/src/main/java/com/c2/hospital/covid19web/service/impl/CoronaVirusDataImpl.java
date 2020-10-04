package com.c2.hospital.covid19web.service.impl;

import com.c2.hospital.covid19web.model.CoronaCountryModel;
import com.c2.hospital.covid19web.model.CoronaStateModel;
import com.c2.hospital.covid19web.service.CoronaVirusData;
import com.c2.hospital.covid19web.service.CoronaVirusDataService;
import com.c2.hospital.covid19web.service.Covid19Utils;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CoronaVirusDataImpl implements CoronaVirusData {

    @Autowired
    CoronaVirusDataService dataService;

    public static Map<String, CoronaCountryModel> countryDataMap = new TreeMap<>();
    private Map<String, CoronaCountryModel> newStats;
    public static Map<String, CoronaCountryModel> arabicCountryDataMap = new TreeMap<>();

    public Map<String, CoronaCountryModel> getCountryDataMap() {
        return getSortedSet();
    }

    public Map<String, CoronaCountryModel> getArabicCountryDataMap() {
        Map<String, CoronaCountryModel> arabCountryDataMap  = getCountryDataMap().entrySet().stream()
                .filter(map -> { return "Algeria".equalsIgnoreCase(map.getKey()) ||
                                        "Bahrain".equalsIgnoreCase(map.getKey()) ||
                                        "Comoros".equalsIgnoreCase(map.getKey()) ||
                                        "Djibouti".equalsIgnoreCase(map.getKey()) ||
                                        "Egypt".equalsIgnoreCase(map.getKey()) ||
                                        "Iraq".equalsIgnoreCase(map.getKey()) ||
                                        "Jordan".equalsIgnoreCase(map.getKey()) ||
                                        "Kuwait".equalsIgnoreCase(map.getKey()) ||
                                        "Lebanon".equalsIgnoreCase(map.getKey()) ||
                                        "Libya".equalsIgnoreCase(map.getKey()) ||
                                        "Mauritania".equalsIgnoreCase(map.getKey()) ||
                                        "Morocco".equalsIgnoreCase(map.getKey()) ||
                                        "Oman".equalsIgnoreCase(map.getKey()) ||
                                        "Palestine".equalsIgnoreCase(map.getKey()) ||
                                        "Qatar".equalsIgnoreCase(map.getKey()) ||
                                        "Saudi Arabia".equalsIgnoreCase(map.getKey()) ||
                                        "Somalia".equalsIgnoreCase(map.getKey()) ||
                                        "Sudan".equalsIgnoreCase(map.getKey()) ||
                                        "Syria".equalsIgnoreCase(map.getKey()) ||
                                        "Tunisia".equalsIgnoreCase(map.getKey()) ||
                                        "United Arab Emirates".equalsIgnoreCase(map.getKey()) ||
                                        "Yemen".equalsIgnoreCase(map.getKey());
                })
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        List<Map.Entry<String, CoronaCountryModel>> list = new LinkedList<>(arabCountryDataMap.entrySet());
        Collections.sort(list, Comparator.comparing(o -> o.getValue().getLatestCases()));
        Collections.reverse(list);
        HashMap<String, CoronaCountryModel> sortedMap = new LinkedHashMap<String, CoronaCountryModel>();
        for (Map.Entry<String, CoronaCountryModel> map : list) {
            sortedMap.put(map.getKey(), map.getValue());
        }
        arabicCountryDataMap = sortedMap;
        return  arabicCountryDataMap;
    }

    public void setData(String uri) {
        newStats = new TreeMap<>();
        for (Iterator<CSVRecord> it = dataService.parseCSVIterator(uri); it.hasNext(); ) {
            CSVRecord record = it.next();
            newStats.put(record.get(Covid19Utils.COUNTRY), setCoronaCountyModel(record));
        }
        countryDataMap.putAll(newStats);
    }

    public void setDeathData(String uri) {
        for (Iterator<CSVRecord> it = dataService.parseCSVIterator(uri); it.hasNext(); ) {
            CSVRecord record = it.next();
            setCoronaCountryModelDeathData(record);
        }
    }

    private CoronaCountryModel setCoronaCountyModel(CSVRecord record) {
        CoronaCountryModel model;
        int latestCase = (!record.get(record.size() - 1).isEmpty()) ?
                Integer.parseInt(record.get(record.size() - 1)) : 0;
        int prevDayCase = (!record.get(record.size() - 2).isEmpty()) ?
                Integer.parseInt(record.get(record.size() - 2)) : 0;
        if (newStats.containsKey(record.get(Covid19Utils.COUNTRY))) {
            model = newStats.get(record.get(Covid19Utils.COUNTRY));
            boolean valueUpdated = (!record.get(record.size() - 1).isEmpty());
            if (!valueUpdated) {
                model.setUpdated(valueUpdated);
            }
            if (valueUpdated) {
                model.setLatestCases(model.getLatestCases() + latestCase);
                model.setDiffFromPrevDay(model.getDiffFromPrevDay() + latestCase - prevDayCase);
            }
        } else {
            model = new CoronaCountryModel();
            model.setCountry(record.get(Covid19Utils.COUNTRY));
            boolean valueUpdated = (!record.get(record.size() - 1).isEmpty());
            model.setUpdated(valueUpdated);
            if (valueUpdated) {
                model.setLatestCases(latestCase);
                model.setDiffFromPrevDay(latestCase - prevDayCase);
            }

        }
        if (record.get(Covid19Utils.STATE).isEmpty()) {
            model.setLatitude(Double.parseDouble(record.get(Covid19Utils.LATITUDE)));
            model.setLongitude(Double.parseDouble(record.get(Covid19Utils.LONGITUDE)));
        } else {
            model.getStateModelsList().add(setCoronaStateModel(record));
        }
        return model;
    }

    private CoronaStateModel setCoronaStateModel(CSVRecord record) {
        CoronaStateModel model = new CoronaStateModel();
        boolean valueUpdated = (!record.get(record.size() - 1).contentEquals(""));
        model.setUpdated(valueUpdated);
        if (valueUpdated) {
            int latestCase = Integer.parseInt(record.get(record.size() - 1));
            int prevDayCase = Integer.parseInt(record.get(record.size() - 2));
            model.setLatestCases(latestCase);
            model.setDiffFromPrevDay(latestCase - prevDayCase);
        }
        model.setState(record.get(Covid19Utils.STATE));
        model.setLatitude(Double.parseDouble(record.get(Covid19Utils.LATITUDE)));
        model.setLongitude(Double.parseDouble(record.get(Covid19Utils.LONGITUDE)));
        return model;
    }

    private void setCoronaCountryModelDeathData(CSVRecord record) {
        CoronaCountryModel model = newStats.get(record.get(Covid19Utils.COUNTRY));
        int death = (!record.get(record.size() - 1).isEmpty()) ? Integer.parseInt(record.get(record.size() - 1)) : 0;
        int prevDeath = death - Integer.parseInt(record.get(record.size() - 2));
        if (model.getDeath() > 0) death += model.getDeath();
        if (model.getDeathDiffFromPrevDay() > 0) prevDeath += model.getDeathDiffFromPrevDay();
        model.setDeath(death);
        model.setDeathDiffFromPrevDay(prevDeath);
        if(!record.get(Covid19Utils.STATE).isEmpty()) setCoronaStateModelDeathData(record, model);
    }

    private void setCoronaStateModelDeathData(CSVRecord record, CoronaCountryModel model) {
        for (CoronaStateModel stateModel : model.getStateModelsList()) {
            if(record.get(Covid19Utils.STATE).contentEquals(stateModel.getState())) {
                int death = (!record.get(record.size() - 1).isEmpty()) ? Integer.parseInt(record.get(record.size() - 1)) : 0;
                stateModel.setDeath(death);
            }
        }
    }

    public void setCountryDataMap() {
        countryDataMap.putAll(newStats);
    }

    private Map<String, CoronaCountryModel> getSortedSet() {
        List<Map.Entry<String, CoronaCountryModel>> list =
                new LinkedList<>(countryDataMap.entrySet());

        Collections.sort(list, Comparator.comparing(o -> o.getValue().getCountry()));

        HashMap<String, CoronaCountryModel> sortedMap = new LinkedHashMap<String, CoronaCountryModel>();
        for (Map.Entry<String, CoronaCountryModel> map : list) {
            sortedMap.put(map.getKey(), map.getValue());
        }
        countryDataMap = sortedMap;
        return sortedMap;
    }
}
