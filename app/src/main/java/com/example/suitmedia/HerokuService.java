package com.example.suitmedia;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HerokuService {

    @GET("hello")
    Call<ResponseBody> hello();

    @GET("name")
    Call<ResponseBody> name();

    @GET("birthdate")
    Call<ResponseBody> birthdate();

    @GET("Image dummy")
    Call<ResponseBody> image();
}
