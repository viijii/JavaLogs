package com.cadrac.logs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("agentlog.php")
    Call<LogResponse> Addlog(@Query("logmsg") String logmsg);
}
