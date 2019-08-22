package com.cadrac.logs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hypertrack.hyperlog.HyperLog;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("TAG", "onCreate:here");
        HyperLog.initialize(this,new CustomLogMesssageFormat(this));
        HyperLog.setLogLevel(Log.VERBOSE);


        String amith ="asd";
        Config.addLog(amith);


        Log.d("TAG", "onCreate: " + amith);


    }
}
