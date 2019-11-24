package com.example.suitmedia.model;

public class Event {

    private String nama, tanggal;
    private int image;

    public Event() {
    }

    public Event(String nama, String tanggal, int image) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


}
