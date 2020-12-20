package com.example.anand.ytvolley;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Butmenu extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    public static String Username_retrieved;
    public static String Rollnumber_retreived;
    public String coding="coding";
    public String jam="jam";
    public String ppt="ppt";
    public String quiz="quiz";
    public String projectexpo="pexpo";
    Button showMenu,but2,but3,but4,but5,but6,but7;
    TextView welcome;
    AlertDialog.Builder builder1;
    String url="http://"+URLs.url1+"/ytvolley/eventreg.php";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Events:
                    Intent i1 = new Intent(Butmenu.this, Butmenu.class);
                    startActivity(i1);
                    return true;
                case R.id.Gallery:
                    Intent i2 = new Intent(Butmenu.this,gallery.class);
                    startActivity(i2);
                    return true;
            }
            return false;
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butmenu);
        welcome = (TextView) findViewById(R.id.textvieww);
        builder1 = new AlertDialog.Builder(Butmenu.this);
        Bundle bundle=getIntent().getExtras();
        Username_retrieved=bundle.getString("name");
        Rollnumber_retreived=bundle.getString("roll");
        welcome.setText("welcome " +Username_retrieved);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getIntent();
        showMenu = (Button) findViewById(R.id.button);
        showMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDown= new PopupMenu(getApplicationContext(), showMenu);
                dropDown.getMenuInflater().inflate(R.menu.eventdetails, dropDown.getMenu());
                dropDown.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        //Coding event
                        if (id == R.id.view) {
                            Intent i1 = new Intent(Butmenu.this, userview.class);
                            startActivity(i1);
                            return true;
                        }
                                                    /*if (id == R.id.update) {
                                                        Intent i2 = new Intent(Butmenu.this, update.class);
                                                        startActivity(i2);
                                                        return true;
                                                    }*/
                                                    /*if (id == R.id.delete) {
                                                        Intent i3 = new Intent(Butmenu.this, MainActivity.class);
                                                        startActivity(i3);
                                                        return true;
                                                    } */
                        if (id == R.id.winners) {
                            Intent i3 = new Intent(Butmenu.this, Coding_Winners.class);
                            startActivity(i3);
                            return true;
                        }
                        if (id == R.id.reg) {

                            StringRequest stringRequest1=new StringRequest(Request.Method.POST,url, new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray1=new JSONArray(response);
                                        JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                                        String code = jsonObject1.getString("code");
                                        String message = jsonObject1.getString("message");
                                        builder1.setTitle("server response...");
                                        builder1.setMessage(message);
                                        displayAlert(code);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<String, String>();
                                    params.put("event",coding);
                                    params.put("rollnumber",Rollnumber_retreived);
                                    // params.put("password",pass);
                                    return params;
                                }
                            };
                            MySingleton.getInstance(Butmenu.this).addToRequestque(stringRequest1);



                            return true;
                        }
                        return true;
                    }
                }); dropDown.show();
            }
        });

        but2 =(Button) findViewById(R.id.v2);
        but2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), but2);
                dropDownMenu.getMenuInflater().inflate(R.menu.eventdetails, dropDownMenu.getMenu());

                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.view) {
                            Intent view2 = new Intent(Butmenu.this,userview2.class);
                            startActivity(view2);
                            return true;
                        }
                                                /*    if (id == R.id.update) {
                                                        Intent i2 = new Intent(Butmenu.this, update.class);
                                                        startActivity(i2);
                                                        return true;
                                                    }
                                                    if (id == R.id.delete) {
                                                        Intent i3 = new Intent(Butmenu.this, MainActivity.class);
                                                        startActivity(i3);
                                                        return true;
                                                    } */
                        if (id == R.id.winners) {
                            Intent i3 = new Intent(Butmenu.this, Jam_winners.class);
                            startActivity(i3);
                            return true;
                        }
                        if (id == R.id.reg) {
                            //  Intent i3 = new Intent(Butmenu.this, declarewinners.class);
                            //  startActivity(i3);
                            StringRequest stringRequest1=new StringRequest(Request.Method.POST,url, new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray1=new JSONArray(response);
                                        JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                                        String code = jsonObject1.getString("code");
                                        String message = jsonObject1.getString("message");
                                        builder1.setTitle("server response...");
                                        builder1.setMessage(message);
                                        displayAlert(code);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<String, String>();
                                    params.put("event",jam);
                                    params.put("rollnumber",Rollnumber_retreived);
                                    // params.put("password",pass);
                                    return params;
                                }
                            };
                            MySingleton.getInstance(Butmenu.this).addToRequestque(stringRequest1);



                            return true;
                        }
                        return true;
                    }
                });
                dropDownMenu.show();

            }
        });

        but3 =(Button) findViewById(R.id.v3);
        but3.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), but3);
                dropDownMenu.getMenuInflater().inflate(R.menu.eventdetails, dropDownMenu.getMenu());

                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.view) {
                            Intent view3 = new Intent(Butmenu.this, userview3.class);
                            startActivity(view3);
                            return true;
                        }
                       /* if (id == R.id.update) {
                            Intent i2 = new Intent(Butmenu.this, update.class);
                            startActivity(i2);
                            return true;
                        }
                        if (id == R.id.delete) {
                            Intent i3 = new Intent(Butmenu.this, MainActivity.class);
                            startActivity(i3);
                            return true;
                        }*/
                        if (id == R.id.reg) {
                            //  Intent i3 = new Intent(Butmenu.this, declarewinners.class);
                            //  startActivity(i3);
                            StringRequest stringRequest1=new StringRequest(Request.Method.POST,url, new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray1=new JSONArray(response);
                                        JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                                        String code = jsonObject1.getString("code");
                                        String message = jsonObject1.getString("message");
                                        builder1.setTitle("server response...");
                                        builder1.setMessage(message);
                                        displayAlert(code);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<String, String>();
                                    params.put("event",ppt);
                                    params.put("rollnumber",Rollnumber_retreived);
                                    // params.put("password",pass);
                                    return params;
                                }
                            };
                            MySingleton.getInstance(Butmenu.this).addToRequestque(stringRequest1);



                            return true;

                        }
                        if (id == R.id.winners) {
                            Intent i3 = new Intent(Butmenu.this,ppt_winners.class);
                            startActivity(i3);
                            return true;
                        }
                        return true;
                    }
                });
                dropDownMenu.show();

            }
        });

        but4 =(Button) findViewById(R.id.v4);
        but4.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), but4);
                dropDownMenu.getMenuInflater().inflate(R.menu.eventdetails, dropDownMenu.getMenu());

                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.view) {
                            Intent i1 = new Intent(Butmenu.this, userview4.class);
                            startActivity(i1);
                            return true;
                        }
                       /* if (id == R.id.update) {
                            Intent i2 = new Intent(Butmenu.this, update.class);
                            startActivity(i2);
                            return true;
                        }
                        if (id == R.id.delete) {
                            Intent i3 = new Intent(Butmenu.this, MainActivity.class);
                            startActivity(i3);
                            return true;
                        }*/
                        if (id == R.id.reg) {
                            //  Intent i3 = new Intent(Butmenu.this, declarewinners.class);
                            //  startActivity(i3);
                            StringRequest stringRequest1=new StringRequest(Request.Method.POST,url, new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray1=new JSONArray(response);
                                        JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                                        String code = jsonObject1.getString("code");
                                        String message = jsonObject1.getString("message");
                                        builder1.setTitle("server response...");
                                        builder1.setMessage(message);
                                        displayAlert(code);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<String, String>();
                                    params.put("event",quiz);
                                    params.put("rollnumber",Rollnumber_retreived);
                                    // params.put("password",pass);
                                    return params;
                                }
                            };
                            MySingleton.getInstance(Butmenu.this).addToRequestque(stringRequest1);



                            return true;
                        }
                        if (id == R.id.winners) {
                            Intent i3 = new Intent(Butmenu.this, quiz_winners.class);
                            startActivity(i3);
                            return true;
                        }
                        return true;
                    }
                });

                dropDownMenu.show();

            }
        });



        but6 =(Button) findViewById(R.id.v6);
        but6.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), but3);
                dropDownMenu.getMenuInflater().inflate(R.menu.eventdetails, dropDownMenu.getMenu());

                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.view) {
                            Intent i1 = new Intent(Butmenu.this, userview5.class);
                            startActivity(i1);
                            return true;
                        }
                        if (id == R.id.reg) {
                            //Intent i3 = new Intent(Butmenu.this, declarewinn.class);
                            //startActivity(i3);
                            //return true;
                            StringRequest stringRequest1=new StringRequest(Request.Method.POST,url, new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray1=new JSONArray(response);
                                        JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                                        String code = jsonObject1.getString("code");
                                        String message = jsonObject1.getString("message");
                                        builder1.setTitle("server response...");
                                        builder1.setMessage(message);
                                        displayAlert(code);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params=new HashMap<String, String>();
                                    params.put("event",projectexpo);
                                    params.put("rollnumber",Rollnumber_retreived);
                                    // params.put("password",pass);
                                    return params;
                                }
                            };
                            MySingleton.getInstance(Butmenu.this).addToRequestque(stringRequest1);



                            return true;
                        }/*
                        if (id == R.id.update) {
                            Intent i2 = new Intent(Butmenu.this, update.class);
                            startActivity(i2);
                            return true;
                        }
                        if (id == R.id.delete) {
                            Intent i3 = new Intent(Butmenu.this, MainActivity.class);
                            startActivity(i3);
                            return true;
                        }  */
                        if (id == R.id.winners) {
                            Intent i3 = new Intent(Butmenu.this, expo_winners.class);
                            startActivity(i3);
                            return true;
                        }
                        return true;
                    }
                });
                dropDownMenu.show();

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home) {
            finish();

        }
        if (id==R.id.Logout) {
            Intent i3=new Intent(Butmenu

                    .this,MainActivity1.class);
            startActivity(i3);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
    public boolean onMenuItemClick(MenuItem menuItem)
    {
        return false;
    }

    public void displayAlert(final String code)
    {
        builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(code.equals("input_error"))
                {
                    //    Pass.setText("");
                    //    Name.setText("");
                    //    Rollno.setText("");
                }
                else if(code.equals("reg_success"))
                {
                   // finish();
                }
                else if(code.equals("reg_failed"))
                {
                    //   Pass.setText("");
                    //   Name.setText("");
                    //   Rollno.setText("");
                }
            }
        });
        AlertDialog alertDialog=builder1.create();
        alertDialog.show();
    }
}