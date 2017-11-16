package com.spondonict.nazmul.fcmdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button bttoken;
    String server_url="http://192.168.1.126:8080/fcm_insert.php";
    TextView tvstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttoken=(Button)findViewById(R.id.bttoken);
        tvstatus=(TextView)findViewById(R.id.tvstatus);

        bttoken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getResources().getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
                final String token=sharedPreferences.getString(getString(R.string.FCM_Token),"null");
                tvstatus.setText(token);
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    protected Map<String,String> getParams()throws AuthFailureError{
                        Map<String,String> params=new HashMap<String, String>() ;
                        params.put("fcm_token",token);
                        return  params;
                    }
                };
                MySingleton.getmInstanace(MainActivity.this).addtoRequestQueue(stringRequest);
            }
        });
    }
}
