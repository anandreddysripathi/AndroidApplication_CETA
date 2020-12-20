package com.example.anand.ytvolley;

import android.support.v4.view.ViewPager;
import
        android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class login_success extends AppCompatActivity {
      ViewFlipper v_Flipper;
    TextView welcome;
    ViewPager viewPager;
    String username_retreived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);


      /* viewPager =(ViewPager)findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter); */



         welcome = (TextView) findViewById(R.id.textView6);
        Bundle bundle = getIntent().getExtras();
        username_retreived= bundle.getString("username");
        welcome.setText("welcome " + username_retreived);

    /*  int images[]= {R.drawable.chinnu,R.drawable.chinnu,R.drawable.chinnu};

        v_Flipper=(ViewFlipper) findViewById(R.id.v_flipper);

        for(int image: images)
            flipperImages(image);

     */

    }

    /*public void flipperImages(int image)
    {
        ImageView iv=new ImageView(this);
        iv.setBackgroundResource(image);
        v_Flipper.addView(iv);
        v_Flipper.setFlipInterval(4000);
        v_Flipper.setAutoStart(true);

        v_Flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_Flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

   */

}

