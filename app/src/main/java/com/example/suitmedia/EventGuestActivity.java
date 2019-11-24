package com.example.suitmedia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventGuestActivity extends AppCompatActivity {

    @BindView(R.id.tv_username)
    TextView tv_username;

    @BindView(R.id.btn_event)
    Button btn_event;

    @BindView(R.id.btn_guest)
    Button btn_guest;

    String getUsername, getButtonName, getGetButtonNameGuest;
    SharedPreferences mSharedPreferences;
    static final String myprefrence = "mypref";
    static final String NAME = "name";
    static final String EVENT = "nameEvent";
    static final String GUEST = "nameGuest";
    String nameSave, eventSave, guestSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_guest);
        ButterKnife.bind(this);

        getSupportActionBar().hide();

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(EVENT))) {
            getButtonName = getIntent().getStringExtra(EVENT);
            btn_event.setText(getButtonName);
        }

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(GUEST))) {
            getGetButtonNameGuest = getIntent().getStringExtra(GUEST);
            btn_guest.setText(getGetButtonNameGuest);
        }

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(NAME))) {
            getUsername = getIntent().getStringExtra(NAME);
            tv_username.setText(getUsername);
            mSharedPreferences = getSharedPreferences("mypref", 0);
            mSharedPreferences.edit().remove(NAME).apply();
        }

        mSharedPreferences = getSharedPreferences(myprefrence, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains(NAME)) {
            tv_username.setText(mSharedPreferences.getString(NAME, ""));
        }


        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventGuestActivity.this, EventActivity.class);
                nameSave = tv_username.getText().toString();
                eventSave = btn_event.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(NAME, nameSave);
                editor.putString(EVENT, eventSave);

                editor.commit();
                startActivity(intent);
            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventGuestActivity.this, GuestActivity.class);
                nameSave = tv_username.getText().toString();
                guestSave = btn_guest.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(NAME, nameSave);
                editor.putString(GUEST, guestSave);
                editor.commit();
                startActivity(intent);
            }
        });

    }

}
