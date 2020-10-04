package com.c2.hospital.covid19web.service;

import com.c2.hospital.covid19web.exception.APIRuntimeException;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.Iterator;

public interface CoronaVirusDataService {

    String fetchVirusData(String uri) throws APIRuntimeException, IOException;

    Iterator<CSVRecord> parseCSVIterator(String uri);

}
