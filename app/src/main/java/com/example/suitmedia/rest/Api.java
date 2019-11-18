package com.example.suitmedia.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("people")
    Call<GuestResponse> getGuestRes(
            @Query("nama") String nama,
            @Query("birthdate") int birthdate
    );
}
