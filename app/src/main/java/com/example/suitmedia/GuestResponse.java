package com.example.suitmedia;

import com.example.suitmedia.model.Guest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuestResponse {

    @SerializedName("results")
    @Expose
    private List<Guest> mGuests;

    public List<Guest> getTrailers() {
        return mGuests;
    }

    public void setTrailers(List<Guest> mGuest) {
        this.mGuests = mGuest;
    }
}
