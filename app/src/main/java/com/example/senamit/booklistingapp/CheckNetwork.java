package com.example.senamit.booklistingapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by senamit on 1/10/17.
 */

public class CheckNetwork {
    public static final String LOG_TAG = CheckNetwork.class.getSimpleName();


    public static boolean isInternetAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            Log.i(LOG_TAG, "Internet Connection is avaialble");
            return true;

        }
        else {
            Log.i(LOG_TAG, "No internet Connection");
            return false;
        }



    }


}
