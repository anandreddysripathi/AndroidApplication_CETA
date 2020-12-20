package com.example.anand.ytvolley;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Working extends AppCompatActivity {


    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Events:
                    Intent i1 = new Intent(Working.this, Butmenu.class);
                    startActivity(i1);
                    return true;
                case R.id.Gallery:
                    Intent i2 = new Intent(Working.this, gallery.class);
                    startActivity(i2);
                    return true;
            }
            return false;
        }
    };*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getIntent();
      //  BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Button,EditText
        getIntent();

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            finish();

        }


        if (id==R.id.Logout) {
            Intent i3=new Intent(Working.this,MainActivity1.class);
            startActivity(i3);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

}
