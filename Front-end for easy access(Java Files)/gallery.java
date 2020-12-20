package com.example.anand.ytvolley;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class gallery extends Activity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        viewPager=(ViewPager)findViewById(R.id.view1);
        adapter=new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
