package com.example.suitmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.suitmedia.adapter.EventAdapter;
import com.example.suitmedia.data.EventDataDummy;
import com.example.suitmedia.model.Event;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventActivity extends AppCompatActivity {

    @BindView(R.id.rv_event)
    RecyclerView mRecyclerView;


    private boolean isFetchingMovies;
    private int currentPage = 0;
    private ArrayList<Event> list = new ArrayList<>();
    private EventAdapter mEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        list.addAll(EventDataDummy.getData());
        showList();

    }

    public void showList() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEventAdapter = new EventAdapter(list);
        mRecyclerView.setAdapter(mEventAdapter);

    }



}
