package com.example.anand.ytvolley;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {

        Button but1,but2,but3,but4;
       /* private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Events:
                        Intent i1 = new Intent(Help.this, Butmenu.class);
                        startActivity(i1);
                        return true;
                    case R.id.Gallery:
                        Intent i2= new Intent(Help.this, gallery.class);
                        startActivity(i2);

                        return true;
                }
                return false;
            }
        };*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/

        getIntent();
        but1=(Button)findViewById(R.id.b1);

        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
             Intent i0 = new Intent(Help.this,Working.class);
             startActivity(i0);
            }
        });
       /* but2=(Button)findViewById(R.id.b2);
        but2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              Intent i1 = new Intent(Help.this,Contactus.class);
               startActivity(i1);
            }
        });*/
        but3=(Button)findViewById(R.id.b3);
        but3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Help.this,MainActivity1.class);
                startActivity(i1);
            }
        });
        but4=(Button)findViewById(R.id.b4);
        but4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Help.this,Appinfo.class);
                startActivity(i1);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            finish();

        }



        if (id==R.id.Logout) {
            Intent i3=new Intent(Help.this,MainActivity1.class);
            startActivity(i3);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
