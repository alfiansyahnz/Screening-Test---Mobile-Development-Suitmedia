package com.example.suitmedia.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guest {


    @SerializedName("nama")
    @Expose
    private String nama ;

    @SerializedName("birthdate")
    @Expose
    private String birthdate;

    @SerializedName("Image dummy")
    @Expose
    private String imageDummy;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getImageDummy() {
        return imageDummy;
    }

    public void setImageDummy(String imageDummy) {
        this.imageDummy = imageDummy;
    }

    public Guest(String nama, String birthdate, String imageDummy) {
        this.nama = nama;
        this.birthdate = birthdate;
        this.imageDummy = imageDummy;
    }
}
