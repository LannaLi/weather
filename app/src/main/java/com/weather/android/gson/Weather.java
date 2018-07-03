package com.weather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lanna on 2018/7/3.
 */

public class Weather {
    //状态(标识号)
    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

}
