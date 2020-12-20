package com.example.anand.ytvolley;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clubs extends AppCompatActivity {
TextView t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);




        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getIntent();

        t=(TextView) findViewById(R.id.t1);


        t.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i0 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.javatpoint.com"));
                startActivity(i0);
            }
        });
        t1=(TextView) findViewById(R.id.t2);


        t1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.javatpoint.com"));
                startActivity(i1);
            }
        });
        t2=(TextView) findViewById(R.id.t3);


        t2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tutorialspoint.com"));
                startActivity(i2);
            }
        });
        t3=(TextView) findViewById(R.id.t4);


        t3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tutorialspoint.com/r/index.htm"));
                startActivity(i3);
            }
        });
        t4=(TextView) findViewById(R.id.t5);


        t4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hackerrank.com"));
                startActivity(i4);
            }
        });
        t5=(TextView) findViewById(R.id.t6);


        t5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i5);
            }
        });
        t6=(TextView) findViewById(R.id.t7);


        t6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tutorialspoint.com"));
                startActivity(i6);
            }
        });
        t7=(TextView) findViewById(R.id.t8);


        t7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gonaturalenglish.com"));
                startActivity(i7);
            }
        });
        t8=(TextView) findViewById(R.id.t9);


        t8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.indiabix.com"));
                startActivity(i8);
            }
        });
        t9=(TextView) findViewById(R.id.t10);


        t9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i9= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.monstercrawler.com"));
                startActivity(i9);
            }
        });
        t10=(TextView) findViewById(R.id.t11);


        t10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i10 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.javatpoint.com"));
                startActivity(i10);
            }
        });
        t11=(TextView) findViewById(R.id.t12);


        t11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i11 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i11);
            }
        });



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();

        }


        if (id == R.id.Logout) {
            Intent i3 = new Intent(Clubs.this, MainActivity1.class);
            startActivity(i3);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

