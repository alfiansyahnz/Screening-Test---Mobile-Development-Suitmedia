package com.example.suitmedia.rest;

import com.example.suitmedia.model.Guest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestInterface {
    @GET("v2/596dec7f0f000023032b8017")
    Call<Guest> getData();
}
