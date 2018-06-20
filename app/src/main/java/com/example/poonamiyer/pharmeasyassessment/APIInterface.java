package com.example.poonamiyer.pharmeasyassessment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Poonam Iyer on 6/19/2018.
 */

public interface APIInterface {

    @GET("/api/users?")
    Call<UserList> getUserList(@Query("page") String page);
}
