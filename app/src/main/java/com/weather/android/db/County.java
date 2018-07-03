package com.weather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Lanna on 2018/7/2.
 */

public class County extends DataSupport{
    //县的ID
    private int id;
    //县的名称
    private String countyName;
    //县对应的天气ID
    private String weatherId;
    //所属的城市ID
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
