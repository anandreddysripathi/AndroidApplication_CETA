package com.example.anand.ytvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by ANAND on 6/28/2018.
 */

public class expo_winners extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;
    String url="http://"+URLs.url1+"/ytvolley/expowin.php";
    public String name1,name2,name3;
    int pts1,pts2,pts3;
    TextView namefirst,namesecond,namethird,points1,points2,points3,project1,project2,project3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expowin);
        namefirst=(TextView)findViewById(R.id.roll1);
        namesecond=(TextView)findViewById(R.id.roll2);
        namethird=(TextView)findViewById(R.id.roll3);
        points1=(TextView)findViewById(R.id.pots1);
        points2=(TextView)findViewById(R.id.pots2);
        points3=(TextView)findViewById(R.id.pots3);
        project1=(TextView)findViewById(R.id.p1);
        project2=(TextView)findViewById(R.id.p2);
        project3=(TextView)findViewById(R.id.p3);
        jsonParse();
    }
    private void jsonParse() {
        final int[] points=new int[3];
        final String[] name=new String[3];
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("winners");

                            for (int i = 0; i <=3; i++) {
                                JSONObject Winner = jsonArray.getJSONObject(i);
                                 String projectda=Winner.getString("project");
                                String Nameda = Winner.getString("student");
                                int pointsda = Winner.getInt("points");
                                if(i==0)
                                {
                                    project1.setText("Project: "+projectda);
                                    namefirst.setText("Student: "+Nameda);
                                    points1.setText("Points: "+pointsda);
                                }
                                else if(i==1)
                                {
                                    project2.setText("Project: "+projectda);
                                    namesecond.setText("Student: "+Nameda);
                                    points2.setText("Points: "+pointsda);}
                                else
                                {   project3.setText("Project: "+projectda);
                                    namethird.setText("Student: "+Nameda);
                                    points3.setText("Points: "+pointsda);}

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(expo_winners.this).addToRequestque(request);
    }
}

