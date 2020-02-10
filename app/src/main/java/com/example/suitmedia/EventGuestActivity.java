package com.example.suitmedia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventGuestActivity extends AppCompatActivity {

    @BindView(R.id.tv_username)
    TextView tv_username;

    @BindView(R.id.btn_event)
    Button btn_event;

    @BindView(R.id.btn_guest)
    Button btn_guest;

    String getUsername, getButtonName, getGetButtonNameGuest, nameSave, eventSave, guestSave, getBirthdate, fix;
    SharedPreferences mSharedPreferences;
    static final String myprefrence = "mypref";
    static final String NAME = "name";
    static final String EVENT = "nameEvent";
    static final String GUEST = "nameGuest";
    static final String BIRTHDATE = "birthdateGuest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_guest);
        ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).hide();

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(EVENT))) {
            getButtonName = getIntent().getStringExtra(EVENT);
            btn_event.setText(getButtonName);
        }

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(GUEST))) {
            getGetButtonNameGuest = getIntent().getStringExtra(GUEST);
            btn_guest.setText(getGetButtonNameGuest);
        }

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(BIRTHDATE))) {
            getBirthdate = getIntent().getStringExtra(BIRTHDATE);
            try {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
                fix = String.valueOf(myFormat.parse(getBirthdate));
                logic(Integer.parseInt(fix));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra(NAME))) {
            getUsername = getIntent().getStringExtra(NAME);
            tv_username.setText(getUsername);
            mSharedPreferences = getSharedPreferences(myprefrence,0);
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

                editor.apply();
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
                editor.apply();
                startActivity(intent);
            }
        });

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
