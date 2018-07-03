package com.weather.android.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.weather.android.db.City;
import com.weather.android.db.County;
import com.weather.android.db.Province;
import com.weather.android.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lanna on 2018/7/2.
 */

public class Utility {

    /**
     * 将返回的JSON数据解析成Weather实体类
     * @param response
     * @return
     */
    public static Weather handlerWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解析和处理从服务器上获取到的省份数据
     * @param response 服务器返回的数据
     * @return
     */
    public static boolean handlerProviceResponse(String response){
        //如果返回的数据不为空
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvices = new JSONArray(response);
                for (int i=0;i<allProvices.length();i++){
                    JSONObject proviceObject = allProvices.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(proviceObject.getString("name"));
                    province.setProvinceCode(proviceObject.getInt("id"));
                    province.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * @param response 服务器返回的数据
     * @param proviceId 省份ID
     * @return
     */
    public static boolean handlerCityResponse(String response,int proviceId){
        //如果返回的数据不为空
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(proviceId);
                    city.save();
                }
                return true;
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析获取到的县
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handlerCountyResponse(String response,int cityId){
        //如果返回的数据不为空
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

}
