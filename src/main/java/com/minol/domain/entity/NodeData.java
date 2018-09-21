package com.minol.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class NodeData extends Room {
    private Integer room_id;
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp add_time;
    private Double cu_heat;
    private Double cu_cool;
    private Double heat_power;
    private Double instant_energy;
    private Double cu_flow;
    private Double instant_flowrate;
    private Double entrance_temp;
    private Double exit_temp;
    private Double diff_temp;
    private Integer hours;
    /**
     * 电池状态[0:正常1：欠压]
     */
    private String battery_status;
    /**
     * 欠费状态[0:正常1:欠费]
     */
    private Integer payment_status;
    /**
     * 阀门状态[0:开1:关 其他异常
     */
    private Integer valve_status;
    /**
     * 错误标记
     */
    private String  meter_error;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Timestamp getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Timestamp add_time) {
        this.add_time = add_time;
    }

    public Double getCu_heat() {
        return cu_heat;
    }

    public void setCu_heat(Double cu_heat) {
        this.cu_heat = cu_heat;
    }

    public Double getCu_cool() {
        return cu_cool;
    }

    public void setCu_cool(Double cu_cool) {
        this.cu_cool = cu_cool;
    }

    public Double getHeat_power() {
        return heat_power;
    }

    public void setHeat_power(Double heat_power) {
        this.heat_power = heat_power;
    }

    public Double getInstant_energy() {
        return instant_energy;
    }

    public void setInstant_energy(Double instant_energy) {
        this.instant_energy = instant_energy;
    }

    public Double getCu_flow() {
        return cu_flow;
    }

    public void setCu_flow(Double cu_flow) {
        this.cu_flow = cu_flow;
    }

    public Double getInstant_flowrate() {
        return instant_flowrate;
    }

    public void setInstant_flowrate(Double instant_flowrate) {
        this.instant_flowrate = instant_flowrate;
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

    public Integer getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Integer payment_status) {
        this.payment_status = payment_status;
    }

    public Integer getValve_status() {
        return valve_status;
    }

    public void setValve_status(Integer valve_status) {
        this.valve_status = valve_status;
    }

    public String getMeter_error() {
        return meter_error;
    }

    public void setMeter_error(String meter_error) {
        this.meter_error = meter_error;
    }
}
