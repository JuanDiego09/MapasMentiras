package com.example.juan.mapasmentiras.actividades;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juan.mapasmentiras.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        CountDownTimer tiempo;

        tiempo=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                Intent miIntent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(miIntent);
                finish();
            }
        };
        tiempo.start();
    }
}
