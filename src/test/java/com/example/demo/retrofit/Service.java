package com.example.demo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by ChenLY on 2017-09-21.
 */
public interface Service {

    @GET("user")
    Call<List<User>> listUser();

    @GET("s")
    Call<String> search(@Query("wd") String keyword);
}
