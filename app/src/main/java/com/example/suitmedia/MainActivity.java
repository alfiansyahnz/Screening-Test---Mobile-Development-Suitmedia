package com.example.suitmedia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText et_name;

    @BindView(R.id.btn_next)
    Button btn_next;

    static final String NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().hide();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                if (TextUtils.isEmpty(name)){
                    et_name.setError("Enter Name !!");
                    return;
                }
                et_name.setText("");
                Toast.makeText(MainActivity.this, "Hello " + name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, EventGuestActivity.class);
                intent.putExtra(NAME,name );
                startActivity(intent);
            }
        });


    }


}

