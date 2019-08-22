package com.cadrac.logs;

import retrofit2.Retrofit;

public class RestClient {

    public static final String baseUrl = "http://76.184.232.31/haptest/";   //FDC server new
    public static Retrofit client = new Retrofit.Builder().baseUrl(baseUrl).build();
}
