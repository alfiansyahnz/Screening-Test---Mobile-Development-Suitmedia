package com.example.suitmedia.rest;

import com.example.suitmedia.model.Guest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("596dec7f0f000023032b8017")
    Call<List<Guest>> postData();
}
