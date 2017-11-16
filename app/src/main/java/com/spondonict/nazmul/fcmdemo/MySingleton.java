package com.spondonict.nazmul.fcmdemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by USER on 11/15/2017.
 */

public class MySingleton {

    private static MySingleton mInstance;
    private static Context mCtx;
    private RequestQueue requestQueue=null;

    private MySingleton(Context context){
        mCtx=context;
        requestQueue=getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return requestQueue;
    }

    public static synchronized  MySingleton getmInstanace(Context context){
        if(mInstance==null){
            mInstance=new MySingleton(context);
        }
        return mInstance;
    }

    public<T> void addtoRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }
}
