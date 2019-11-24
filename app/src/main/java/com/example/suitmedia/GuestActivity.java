package com.example.suitmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.suitmedia.adapter.GuestAdapter;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.model.Guest;
import com.example.suitmedia.rest.ApiClient;
import com.example.suitmedia.rest.RequestInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestActivity extends AppCompatActivity {

    @BindView(R.id.rv_guest)
    RecyclerView mRecyclerView;

    private GuestAdapter adapter;
    ArrayList<Guest> listGuest = new ArrayList<>();
    ArrayList<Event> listEvent = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Guest");

        final RequestInterface apiInterface = ApiClient.getClient().create(RequestInterface.class);
        Call<Guest> listCall = apiInterface.getData();
        listCall.enqueue(new Callback<Guest>() {
            @Override
            public void onResponse(Call<Guest> call, Response<Guest> response) {
                int id = response.body().getId();
                String name = response.body().getName();
                String birthdate = response.body().getBirthdate();
                listGuest.add(new Guest(id, name, birthdate));
                showRecycleGrid(listGuest, listEvent);
            }

            @Override
            public void onFailure(Call<Guest> call, Throwable t) {
                Toast.makeText(GuestActivity.this, "GAGAL", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSelectedHero(Guest data) {
        Toast.makeText(this, "Kamu Memilih" + data.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecycleGrid(ArrayList<Guest> bodyGuest, ArrayList<Event> bodyEvent) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new GuestAdapter(bodyGuest, bodyEvent);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Guest data) {
                showSelectedHero(data);
            }
        });

    }

//    public void logic(int tgl) {
//
//        if (tgl % 2 == 0 && tgl % 3 == 0) {
//            Toast.makeText(null, "iOS", Toast.LENGTH_LONG).show();
//        } else if (tgl % 3 == 0) {
//            Toast.makeText(null, "Android", Toast.LENGTH_LONG).show();
//        } else if (tgl % 2 == 0) {
//            Toast.makeText(null, "Blackberry", Toast.LENGTH_SHORT).show();
//        }
//    }
}

