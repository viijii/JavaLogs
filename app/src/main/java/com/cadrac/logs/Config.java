package com.cadrac.logs;

import android.text.TextUtils;

import com.hypertrack.hyperlog.HyperLog;

public class Config {

    public static void addLog(String s) {

        if (!TextUtils.isEmpty(s)) {
            HyperLog.i("TAG", s );
            System.out.println("string " + s);
            //Log.d(TAG, "showLogs:logsmsg" + HyperLog.getDeviceLogsAsStringList(false));

        }
    }
}
