package com.example.suitmedia.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HerokuService {

    @GET("name")
    Call<ResponseBody> name();

    @GET("birthdate")
    Call<ResponseBody> birthdate();

    @GET("Image dummy")
    Call<ResponseBody> image();
}
