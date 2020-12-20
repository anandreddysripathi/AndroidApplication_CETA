package com.example.anand.ytvolley;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String rollnumber_retreived,Username_retreived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        rollnumber_retreived = bundle.getString("rollnumber");
        Username_retreived = bundle.getString("username");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

        }
    }

    @Override
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

        //noinspection SimplifiableIfStatement


        if (id==R.id.Logout) {
            Intent i0=new Intent(MainActivity.this,MainActivity1.class);
            startActivity(i0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.Gallery)
        {
            Intent i0=new Intent(MainActivity.this,gallery.class);
           startActivity(i0);
            return true;
        }

         else if (id == R.id.Events) {
           Intent i1=new Intent(MainActivity.this,Butmenu.class);
           i1.putExtra("roll",rollnumber_retreived);
           i1.putExtra("name",Username_retreived);
           startActivity(i1);
           return true;
        }
       else if (id == R.id.Clubs)
       {
           Intent i2=new Intent(MainActivity.this,Clubs.class);
           startActivity(i2);
           return true;
       }
       else if (id == R.id.Innovation)
       {
           Intent i4=new Intent(MainActivity.this,Innovations.class);
           startActivity(i4);
           return true;
       }else if (id == R.id.Coordinator)
       {
           Intent i6=new Intent(MainActivity.this,Coordinatorsfinal.class);
           startActivity(i6);
           return true;
       }

       else if (id == R.id.Help)
       {
         Intent i5=new Intent(MainActivity.this,Help.class);
           startActivity(i5);
           return true;
       }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}