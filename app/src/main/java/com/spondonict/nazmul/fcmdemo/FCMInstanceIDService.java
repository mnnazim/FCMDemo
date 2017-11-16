package com.spondonict.nazmul.fcmdemo;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by USER on 11/15/2017.
 */

public class FCMInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String token=FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getResources().getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(getString(R.string.FCM_Token),token);
        editor.commit();
    }
}
