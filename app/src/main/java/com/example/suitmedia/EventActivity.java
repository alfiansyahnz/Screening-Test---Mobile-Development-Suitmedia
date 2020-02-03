package com.example.suitmedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private ArrayList<Event> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Event");
        list.addAll(EventDataDummy.mEventList());
        showList();

    }

    public void showList() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        EventAdapter eventAdapter = new EventAdapter(list);
        mRecyclerView.setAdapter(eventAdapter);

    }


}
