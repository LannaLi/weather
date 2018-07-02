package com.weather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Lanna on 2018/7/2.
 */

public class Province extends DataSupport{
    //省份ID
    private int id;
    //省份名字
    private String provinceName;
    //省份代号
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
