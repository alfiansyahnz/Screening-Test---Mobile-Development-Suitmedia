package com.example.suitmedia;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suitmedia.adapter.GuestAdapter;
import com.example.suitmedia.callback.OnGetGuestCallback;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.data.EventDataDummy;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.model.Guest;
import com.example.suitmedia.rest.GuestRepository;
import com.example.suitmedia.rest.HerokuService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class GuestActivity extends AppCompatActivity {

    @BindView(R.id.rv_guest)
    RecyclerView mRecyclerView;

    private ArrayList<Event> list = new ArrayList<>();
    boolean isFetchingGuest;
    GuestRepository mGuestRepository;
    private GuestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        ButterKnife.bind(this);

        mGuestRepository = GuestRepository.getInstance();
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        getGuest();
//        list.addAll(EventDataDummy.getData());
    }


//    private void showRecycleGrid() {
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        GuestAdapter adapter = new GuestAdapter(list);
//        mRecyclerView.setAdapter(adapter);
//
////        adapter.setOnItemClickCallback(new OnItemClickCallback() {
////            @Override
////            public void onItemClicked(Event data) {
////                showSelectedHero(data);
////            }
////        });
//
//    }

    private void getGuest() {
        isFetchingGuest = true;
        mGuestRepository.getGuest(new OnGetGuestCallback() {
            @Override
            public void onSuccess(List<Guest> guest) {
                adapter = new GuestAdapter(guest ,callback);
                mRecyclerView.setAdapter(adapter);
                isFetchingGuest = false;
            }

            @Override
            public void onError() {
                showError();
            }
        });


    }

    OnItemClickCallback callback = new OnItemClickCallback() {
        @Override
        public void onItemClicked(Guest data) {

            Intent intent = new Intent(GuestActivity.this, EventGuestActivity.class);
            intent.putExtra(EventGuestActivity.GUEST, data.getNama());
            Toast.makeText(GuestActivity.this, "Kamu Memilih" + data.getNama(), Toast.LENGTH_SHORT).show();
            logic(data.getBirthdate());
            startActivity(intent);
        }
    };

    private void showError() {
        Toast.makeText(this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
    }

    public void logic(int tgl) {

        if (tgl % 2 == 0 && tgl % 3 == 0) {
            Toast.makeText(null, "iOS", Toast.LENGTH_LONG).show();
        } else if (tgl % 3 == 0) {
            Toast.makeText(null, "Android", Toast.LENGTH_LONG).show();
        } else if (tgl % 2 == 0) {
            Toast.makeText(null, "Blackberry", Toast.LENGTH_SHORT).show();
        }
    }

}

