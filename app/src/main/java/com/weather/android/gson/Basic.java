package com.weather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lanna on 2018/7/3.
 */

public class Basic {
    @SerializedName("id")
    public String weatherId;

    @SerializedName("city")
    public String cityName;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
