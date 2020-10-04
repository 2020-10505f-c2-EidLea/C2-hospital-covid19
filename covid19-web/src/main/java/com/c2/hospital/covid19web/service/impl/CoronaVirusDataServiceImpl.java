package com.c2.hospital.covid19web.service.impl;

import com.c2.hospital.covid19web.exception.APIRuntimeException;
import com.c2.hospital.covid19web.service.CoronaVirusDataService;
import com.c2.hospital.covid19web.service.Covid19Utils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

@Service
public class CoronaVirusDataServiceImpl implements CoronaVirusDataService {
    @Override
    public String fetchVirusData(String uri) {
        String apiOutput = null;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet getRequest = new HttpGet(uri);
            HttpResponse response = null;
            response = httpClient.execute(getRequest);

            int statusCode = Covid19Utils.NOT_FOUND;
            if (response != null && response.getStatusLine() != null)
                statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != Covid19Utils.SUCCESS) {
                throw new APIRuntimeException("Failed with HTTP error code : " + statusCode);
            }
            HttpEntity httpEntity = response.getEntity();
            apiOutput = EntityUtils.toString(httpEntity);
        } catch (IOException | APIRuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiOutput;
    }

    @Override
    public Iterator<CSVRecord> parseCSVIterator(String uri) {
        Iterable<CSVRecord> records = null;
        try {
            StringReader csvReader = new StringReader(fetchVirusData(uri));
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records.iterator();
    }
}
