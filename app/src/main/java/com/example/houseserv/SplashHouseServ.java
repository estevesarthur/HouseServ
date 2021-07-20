package com.example.houseserv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashHouseServ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_houseserv);

        Handler handler = new Handler();
        handler.postDelayed(() ->  {
            startActivity(new Intent(SplashHouseServ.this, MainActivity.class));
        }, 4000);
    }
}
