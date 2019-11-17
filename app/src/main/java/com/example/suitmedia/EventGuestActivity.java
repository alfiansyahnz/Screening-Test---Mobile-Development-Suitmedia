package com.example.suitmedia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

    String getUsername, getButtonName;
    SharedPreferences mSharedPreferences;
    static final String myprefrence = "mypref";
    static final String NAME = "name";
    static final String BUTTON = "Pilih Event";
    String nameSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_guest);
        ButterKnife.bind(this);

        if (null != getIntent() && !TextUtils.isEmpty(getIntent().getStringExtra("nameEvent"))) {
            getButtonName = getIntent().getStringExtra("nameEvent");
            btn_event.setText(getButtonName);
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
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString(NAME, nameSave);
                editor.commit();
                startActivity(intent);
            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventGuestActivity.this, GuestActivity.class);

                startActivity(intent);
            }
        });

    }

}
