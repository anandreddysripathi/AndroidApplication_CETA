package com.example.anand.ytvolley;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anand.ytvolley.MainActivity;
import com.example.anand.ytvolley.R;

public class Splash extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){

                Intent i=new Intent(Splash.this,MainActivity1.class);
                startActivity(i);
                finish();

            }

        },3000);

    }
}
