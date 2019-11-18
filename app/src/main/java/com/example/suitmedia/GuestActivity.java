package com.example.suitmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GuestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" http://dry-sierra-6832.herokuapp.com/api/people/")
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);

    }

}
