package com.example.anand.ytvolley;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class Contactus extends AppCompatActivity {
    Button but,but1;
    private String email,problem;
    EditText e1,e2;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Events:
                   Intent i1 = new Intent(Contactus.this, Butmenu.class);
                   startActivity(i1);
                    return true;
                case R.id.Gallery:
                    Intent i2 = new Intent(Contactus.this, gallery.class);
                    startActivity(i2);
                    return true;

            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        getIntent();
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        e1=(EditText)findViewById(R.id.problem) ;
        e2=(EditText)findViewById(R.id.email);
        but=(Button)findViewById(R.id.button1);

        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i0 = new Intent(Contactus.this,Clubs.class);
                startActivity(i0);
            }
        });
        but1=(Button)findViewById(R.id.contactsub);

        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                problem=e1.getText().toString().trim();
                email=e2.getText().toString().trim();
                if(problem.isEmpty()||problem.length()<1)
                    e1.setError("please describe ypur problem");
                else if(email.isEmpty()||! Patterns.EMAIL_ADDRESS.matcher(email).matches())
                    e2.setError("please enter valid email");
                else {
                    Toast.makeText(getApplicationContext(), "Succesfully submitted", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Contactus.this, Contactus.class);
                    startActivity(i);


                }
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            finish();

        }


        if (id==R.id.Logout) {
            Intent i3=new Intent(Contactus.this,MainActivity.class);
            startActivity(i3);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
