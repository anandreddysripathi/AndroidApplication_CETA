package com.example.anand.ytvolley;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity1 extends AppCompatActivity {
    TextView textView;
    Button login_button;
    EditText Username,Password;
    String username,password;
    String url="http://"+URLs.url1+"/ytvolley/login.php";
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        TextView text=(TextView)findViewById(R.id.textView);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent("x1");
                startActivity(i);
            }
        });
        builder=new AlertDialog.Builder(MainActivity1.this);
        login_button=(Button)findViewById(R.id.button2);
        Username=(EditText)findViewById(R.id.editText4);
        Password=(EditText)findViewById(R.id.editText5);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=Username.getText().toString();
                password=Password.getText().toString();
                if(username.equals("")||password.equals(""))
                {
                    builder.setTitle("Something Went wrong");
                    displayAlert("Enter all fields");
                }
                else
                {
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray=new JSONArray(response);
                                JSONObject jsonObject=jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code").toString();
                                // String message = jsonObject.getString("message").toString();
                                if(code.equals("login_failed"))
                                {
                                    builder.setTitle("Login Error");
                                    displayAlert("Incorrect Username or Password");
                                }
                                else if(code.equals("login_success_admin"))
                                {
                                    Intent intent=new Intent(MainActivity1.this,MainActivity.class);
                                    startActivity(intent);
                                }
                                else if(code.equals("login_success"))
                                {
                                    Intent intent=new Intent(MainActivity1.this,MainActivity.class);
                                    Bundle bundle=new Bundle();
                                    bundle.putString("username",jsonObject.getString("username"));
                                    bundle.putString("rollnumber",jsonObject.getString("rollnumber"));
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity1.this,"Please Connect to internet",Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<String, String>();
                            params.put("username",username);
                            params.put("password",password);
                            return params;
                        }
                    };
                    MySingleton.getInstance(MainActivity1.this).addToRequestque(stringRequest);
                }
            }
        });
    }
    public void displayAlert(String message)
    {
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Username.setText("");
                Password.setText("");
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}