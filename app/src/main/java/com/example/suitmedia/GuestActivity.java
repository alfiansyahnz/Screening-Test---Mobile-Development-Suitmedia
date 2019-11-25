package com.example.suitmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.suitmedia.adapter.GuestAdapter;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.model.Guest;
import com.example.suitmedia.rest.ApiClient;
import com.example.suitmedia.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GuestActivity extends AppCompatActivity {

    @BindView(R.id.rv_guest)
    RecyclerView mRecyclerView;

    private ApiService apiInterface;
    private GuestAdapter adapter;
    private Call<List<Guest>> listGuest;
    private ArrayList<Event> listEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Guest");
        apiInterface = ApiClient.createService(ApiService.class);

        getData();
        initRecycleView();

    }

    private void showSelectedItem(Guest data) {
        Toast.makeText(this, "Kamu Memilih" + data.getName(), Toast.LENGTH_SHORT).show();
    }

    private void initRecycleView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void getData() {
        listGuest = apiInterface.postData();
        listGuest.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                Log.w("GuestActivity", "onResponse: " + response);
                if (response.isSuccessful()) {
                    List<Guest> guestList = response.body();
                    adapter = new GuestAdapter(guestList , listEvent);
                    mRecyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Toast.makeText(GuestActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

