package com.example.suitmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventGuestActivity extends AppCompatActivity {

    @BindView(R.id.tv_username)
    TextView tv_username;

    @BindView(R.id.btn_event)
    Button btn_event;

    @BindView(R.id.btn_guest)
    Button btn_guest;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_guest);
        ButterKnife.bind(this);

        username = getIntent().getStringExtra("name");
        tv_username.setText(username);


        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventGuestActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventGuestActivity.this, GuestActivity.class);
            }
        });

    }
}
