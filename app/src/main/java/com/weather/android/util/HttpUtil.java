package com.weather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * Created by Lanna on 2018/7/2.
 */

public class HttpUtil {

    public static void sendOkhttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

}
