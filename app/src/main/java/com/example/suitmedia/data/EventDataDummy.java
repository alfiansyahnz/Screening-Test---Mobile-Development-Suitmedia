package com.example.suitmedia.data;

import com.example.suitmedia.model.Event;

import java.util.ArrayList;

public class EventDataDummy {

    public static String[][] data = new String[][]{
            {"Konser Rock Band ", "20 February" ,"https://cdn.pixabay.com/photo/2015/05/15/14/50/concert-768722__340.jpg"},
            {"Liver Music Batu", "20 February" , "https://cdn.pixabay.com/photo/2017/04/10/16/55/live-music-2219036__340.jpg"},
            {"Koktail Sosialisasi", "20 February" ,"https://cdn.pixabay.com/photo/2016/01/19/15/07/cocktails-1149171__340.jpg"},
            {"Gelanggang Pekan Raya", "20 February", "https://cdn.pixabay.com/photo/2016/01/19/17/18/fairground-1149626__340.jpg"},
            {"Konser Kinerja Musik", "20 February", "https://cdn.pixabay.com/photo/2015/10/12/15/09/concert-984237__340.jpg"}

    };

    public static ArrayList<Event> getData() {
        ArrayList<Event> list = new ArrayList<>();
        for (String[] aData : data) {
            Event event = new Event();
            event.setNama(aData[0]);
            event.setTanggal(aData[1]);
            event.setImage(aData[2]);
            list.add(event);

        }
        return list;
    }
}
