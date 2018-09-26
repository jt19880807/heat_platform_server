package com.minol.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class MeterData extends Meter_List {
    private Integer meter_id;
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp meter_datatime;
    private Double cu_heat;
    private Double heat_power;
    private Double cu_flow;
    private Double flow_rate;
    private Double entrance_temp;
    private Double exit_temp;
    private Double diff_temp;
    private Integer hours;

    /**
     * 电池状态[0:正常1：欠压]
     */
    private String battery_status;
    /**
     * 错误列表
     */
    private String  err_list;

    public Integer getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(Integer meter_id) {
        this.meter_id = meter_id;
    }

    public Timestamp getMeter_datatime() {
        return meter_datatime;
    }

    public void setMeter_datatime(Timestamp meter_datatime) {
        this.meter_datatime = meter_datatime;
    }

    public Double getCu_heat() {
        return cu_heat;
    }

    public void setCu_heat(Double cu_heat) {
        this.cu_heat = cu_heat;
    }

    public Double getHeat_power() {
        return heat_power;
    }

    public void setHeat_power(Double heat_power) {
        this.heat_power = heat_power;
    }

    public Double getCu_flow() {
        return cu_flow;
    }

    public void setCu_flow(Double cu_flow) {
        this.cu_flow = cu_flow;
    }

    public Double getFlow_rate() {
        return flow_rate;
    }

    public void setFlow_rate(Double flow_rate) {
        this.flow_rate = flow_rate;
    }

    public Double getEntrance_temp() {
        return entrance_temp;
    }

    public void setEntrance_temp(Double entrance_temp) {
        this.entrance_temp = entrance_temp;
    }

    public Double getExit_temp() {
        return exit_temp;
    }

    public void setExit_temp(Double exit_temp) {
        this.exit_temp = exit_temp;
    }

    public Double getDiff_temp() {
        return diff_temp;
    }

    public void setDiff_temp(Double diff_temp) {
        this.diff_temp = diff_temp;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getBattery_status() {
        return battery_status;
    }

    public void setBattery_status(String battery_status) {
        this.battery_status = battery_status;
    }

    public String getErr_list() {
        return err_list;
    }

    public void setErr_list(String err_list) {
        this.err_list = err_list;
    }
}
