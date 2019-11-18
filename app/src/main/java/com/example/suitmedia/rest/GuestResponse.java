package com.example.suitmedia.rest;

import android.graphics.Movie;

import com.example.suitmedia.model.Guest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuestResponse {

    @SerializedName("results")
    @Expose
    private List<Guest> mGuests;

    public List<Guest> getGuests() {
        return mGuests;
    }

    public void setGuests(List<Guest> guests) {
        mGuests = guests;
    }


}
