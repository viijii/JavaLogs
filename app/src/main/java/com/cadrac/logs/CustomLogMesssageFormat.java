package com.cadrac.logs;

import android.content.Context;
import android.util.Log;

import com.hypertrack.hyperlog.LogFormat;


import java.sql.Timestamp;
import java.util.Date;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomLogMesssageFormat extends LogFormat {

    LogResponse logResponse;
    public CustomLogMesssageFormat(Context context) {
        super(context);
    }

    @Override
    public String getFormattedLogMessage(String logLevelName, String message, String timeStamp, String senderName, String osVersion, String deviceUUID) {

        Date date = new Date();


        String formattedMessage = new Timestamp(date.getTime()) + " : : " + deviceUUID + " : " +osVersion+" : "+ message;

        OkHttpClient okHttpClient = new OkHttpClient();
        RestClient.client = new Retrofit.Builder().baseUrl(RestClient.baseUrl).
                client(okHttpClient).
                addConverterFactory(GsonConverterFactory
                        .create()).build();
        API api = RestClient.client.create(API.class);

        Call<LogResponse> call=api.Addlog(formattedMessage);

        call.enqueue(new Callback<LogResponse>() {
            @Override
            public void onResponse(Call<LogResponse> call, Response<LogResponse> response) {

                logResponse=response.body();

                if(logResponse.getStatus().equalsIgnoreCase("true")){

                    Log.d("TAG", "onResponse:logd added");

                }
            }

            @Override
            public void onFailure(Call<LogResponse> call, Throwable t) {

                Log.d("TAG", "onResponse:error in log" + t);
            }
        });

        return formattedMessage;



    }
}
