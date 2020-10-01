package com.c2.hospital.covid19web.service;

import com.c2.hospital.covid19web.exception.APIRuntimeException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Covid19Utils {
    public static String GATEWAY_URL = "http://localhost:8888/api";
    public static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    public static  String DEATH_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";

    public static final int NOT_FOUND = 404;
    public static final int SUCCESS = 200;
    public static final String STATE = "Province/State";
    public static final String COUNTRY = "Country/Region";
    public static final String LATITUDE = "Lat";
    public static final String LONGITUDE = "Long";

    /**
     * fetchData
     * @param uri
     * @return
     * @throws Exception
     */
    public static String fetchData(String uri)  throws Exception
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(GATEWAY_URL+uri);
        System.out.println("fetch Data from : " + GATEWAY_URL+uri);
        HttpResponse response = httpClient.execute(getRequest);

        int statusCode = NOT_FOUND;
        if (response != null && response.getStatusLine() != null)
            statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != SUCCESS) {
            throw new APIRuntimeException("Failed with HTTP error code : " + statusCode);
        }
        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity);
    }

    /**
     * putData
     * @param uri
     * @param inputJson
     * @return
     * @throws Exception
     */
    public static String putData(String uri, String inputJson) throws Exception
    {
        HttpPut putRequest = new HttpPut(GATEWAY_URL+uri);
        StringEntity entity = new StringEntity(inputJson, ContentType.APPLICATION_JSON);
        putRequest.setEntity(entity);
        System.out.println("send Data to : " + GATEWAY_URL+uri + ", put : " + inputJson);
        return execute(putRequest);
    }

    /**
     * postData
     * @param uri
     * @param inputJson
     * @return
     * @throws Exception
     */
    public static String postData(String uri, String inputJson) throws Exception
    {
        HttpPost postRequest = new HttpPost(GATEWAY_URL+uri);
        StringEntity entity = new StringEntity(inputJson, ContentType.APPLICATION_JSON);
        postRequest.setEntity(entity);
        System.out.println("post Data to : " + GATEWAY_URL+uri + ", put : " + inputJson);
        return execute(postRequest);
    }

    /**
     * deleteData
     * @param uri
     * @return
     * @throws Exception
     */
    public static String deleteData(String uri) throws Exception
    {
        HttpDelete httpDelete = new HttpDelete(GATEWAY_URL+uri);
        System.out.println("delete Data from : " + GATEWAY_URL+uri);
        return execute(httpDelete);
    }

    static String execute(HttpRequestBase httpRequestBase) throws Exception
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        StringBuffer result = new StringBuffer();
        HttpResponse response = httpClient.execute(httpRequestBase);

        //Throw runtime exception if status code isn't 200
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }

        //Create the StringBuffer object and store the response into it.
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        while ((line = br.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
