package com.example.anand.ytvolley;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class Registration extends AppCompatActivity {
    Button register_button;
    EditText Rollno,Name,Pass;
    String rollno,name,pass;
    AlertDialog.Builder builder;
    String url="http://"+URLs.url1+"/ytvolley/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String regex="^(1)+[5-9]{1}+88+[0-9]{1}+A+0+5+[A-Z0-9]{2}+$";
        setContentView(R.layout.activity_registration);
        register_button=(Button)findViewById(R.id.button);
        Rollno=(EditText)findViewById(R.id.editText);
        Name=(EditText)findViewById(R.id.editText2);
        Pass=(EditText)findViewById(R.id.editText3);
        builder=new AlertDialog.Builder(Registration.this);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno =Rollno.getText().toString();
                name=Name.getText().toString();
                pass=Pass.getText().toString();
                boolean validateroll=rollno.matches(regex);
                if(rollno.equals("")||name.equals("")||pass.equals(""))
                {
                    builder.setTitle("Something Went Wrong");
                    builder.setMessage("Enter all Fields");
                    displayAlert("input_error");
                }
                else if((rollno.length()<10) || (rollno.length()>10) || !(validateroll))
                {
                    builder.setTitle("Something Went Wrong");
                    builder.setMessage("Enter valid rollnumber");
                    displayAlert("roll_error");
                }
                else if(pass.length()<5)
                {
                    builder.setTitle("Need more secure password");
                    builder.setMessage("Please enter password of minimum 6 letters");
                    displayAlert("password_error");
                }
                else
                {
                    StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray=new JSONArray(response);
                                JSONObject jsonObject=jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                String message = jsonObject.getString("message");
                                builder.setTitle("Server Response...");
                                builder.setMessage(message);
                                displayAlert(code);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Registration.this,"Please Connect to internet",Toast.LENGTH_SHORT).show();
                            error.printStackTrace();

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<String, String>();
                            params.put("rollnumber",rollno);
                            params.put("username",name);
                            params.put("password",pass);
                            return params;
                        }
                    };
                    MySingleton.getInstance(Registration.this).addToRequestque(stringRequest);

                }
            }
        });
    }

    public void displayAlert(final String code)
    {
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(code.equals("input_error"))
                {
                 Pass.setText("");
                 Name.setText("");
                 Rollno.setText("");
                }
                else if(code.equals("roll_error"))
                {
                    Rollno.setText("");
                }
                else if(code.equals("password_error"))
                {
                    Pass.setText("");
                }
                else if(code.equals("reg_success"))
                {
                    finish();
                }
                else if(code.equals("reg_failed"))
                {
                    Pass.setText("");
                    Name.setText("");
                    Rollno.setText("");
                }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
