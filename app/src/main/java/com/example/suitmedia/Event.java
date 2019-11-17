package com.example.suitmedia;

public class Event {

    private String nama, image, tanggal;

    public Event() {
    }

    public Event(String nama, String image, String tanggal) {
        this.nama = nama;
        this.image = image;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


}
