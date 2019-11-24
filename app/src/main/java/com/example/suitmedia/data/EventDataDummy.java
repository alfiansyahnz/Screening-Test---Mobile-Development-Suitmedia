package com.example.suitmedia.data;

import com.example.suitmedia.R;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.model.Guest;

import java.util.ArrayList;
import java.util.List;

public class EventDataDummy {


    public static List<Event> mEventList(){
        Event konserRockBand= new Event("Konser Rock Band ","20 November", R.drawable.concert) ;
        Event liverMusicBatu = new Event("Liver Music Batu","15 Desember", R.drawable.livemusic) ;
        Event koktailSosialisasi = new Event("Koktail Sosialisasi","24 Januari", R.drawable.cocktails) ;
        Event gelanggangPekanRaya = new Event("Gelanggang Pekan Raya","27 Februari", R.drawable.fairground) ;
        Event konserKinerjaMusik = new Event("Konser Kinerja Musik","18 Maret", R.drawable.concert2) ;


        List<Event> eventList = new ArrayList<>();

        eventList.add(konserRockBand);
        eventList.add(liverMusicBatu);
        eventList.add(koktailSosialisasi);
        eventList.add(gelanggangPekanRaya);
        eventList.add(konserKinerjaMusik);
        return eventList;
    }

}
