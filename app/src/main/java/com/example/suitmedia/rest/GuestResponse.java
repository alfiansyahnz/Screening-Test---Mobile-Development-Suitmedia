package com.example.suitmedia.rest;

import android.graphics.Movie;

import com.example.suitmedia.model.Guest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuestResponse {

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("total_results")
    @Expose
    private int totalResults;

    @SerializedName("results")
    @Expose
    private List<Guest> mGuests;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Guest> getGuests() {
        return mGuests;
    }

    public void setGuests(List<Guest> guests) {
        mGuests = guests;
    }


}
