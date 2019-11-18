package com.example.suitmedia.rest;

import android.util.Log;

import com.example.suitmedia.callback.OnGetGuestCallback;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.model.Guest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuestRepository {

    private static final String BASE_URL = " http://dry-sierra-6832.herokuapp.com/api/people";
    private static final String LANGUAGE = "en-US";
    public static final String POPULAR = "popular";
    public static final String TOP_RATED = "top_rated";
    public static final String UPCOMING = "upcoming";

    private Api api;
    private static GuestRepository repository;

    private GuestRepository(Api api) {
        this.api = api;
    }

    public static GuestRepository getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new GuestRepository(retrofit.create(Api.class));
        }

        return repository;
    }

    public void getGuest( final OnGetGuestCallback callback) {
        api.getGuestRes("name",1).enqueue(new Callback<GuestResponse>() {
            @Override
            public void onResponse(Call<GuestResponse> call, Response<GuestResponse> response) {
                if (response.isSuccessful()) {
                    GuestResponse guestResponse = response.body();
                    if (guestResponse != null && guestResponse.getGuests() != null) {
                        callback.onSuccess(guestResponse.getGuests());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<GuestResponse> call, Throwable t) {
                callback.onError();
            }
        });

    }
}
