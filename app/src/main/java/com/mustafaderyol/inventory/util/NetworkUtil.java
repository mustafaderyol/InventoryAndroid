package com.mustafaderyol.inventory.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 * Created by MstfDryl on 20.12.2015.
 */
public class NetworkUtil {

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;


    public static int getConnectivityStatus(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (null != activeNetwork) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                    return TYPE_WIFI;

                if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                    return TYPE_MOBILE;
            }
        }catch (Exception e) {
        }
        return TYPE_NOT_CONNECTED;
    }

    public static int getConnectivityStatusString(Context context) {
        int conn = NetworkUtil.getConnectivityStatus(context);
       /*
            String status = null;
            if (conn == NetworkUtil.TYPE_WIFI) {
                status = "Wifi enabled";
            } else if (conn == NetworkUtil.TYPE_MOBILE) {
                status = "Mobile data enabled";
            } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
                status = "Not connected to Internet";
            }
        */
        return conn;
    }
}