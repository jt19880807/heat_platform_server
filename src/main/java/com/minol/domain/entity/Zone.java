package com.minol.domain.entity;

public class Zone {
    private Integer id;
    private String z_name;
    private String city_code;
    private String code;
    private String longitude;
    private String latitude;
    /**
     * 隶属换热站ID
     */
    private Integer heat_e_station_id;
    /**
     * 数据上传周期
     */
    private String data_period;
    /**
     * 小区计量方式：0:热量表法1:温度面积法2:通断时间面积法
     */
    private Integer heat_type;
    /**
     * 费率ID
     */
    private Integer rate_id;
    /**
     * 小区地址
     */
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZ_name() {
        return z_name;
    }

    public void setZ_name(String z_name) {
        this.z_name = z_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getHeat_e_station_id() {
        return heat_e_station_id;
    }

    public void setHeat_e_station_id(Integer heat_e_station_id) {
        this.heat_e_station_id = heat_e_station_id;
    }

    public String getData_period() {
        return data_period;
    }

    public void setData_period(String data_period) {
        this.data_period = data_period;
    }

    public Integer getHeat_type() {
        return heat_type;
    }

    public void setHeat_type(Integer heat_type) {
        this.heat_type = heat_type;
    }

    public Integer getRate_id() {
        return rate_id;
    }

    public void setRate_id(Integer rate_id) {
        this.rate_id = rate_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
