package com.minol.domain.entity;

public class ProjectBaseInfo {
    private int company_count;
    private int source_plant_count;
    private int exchange_station_count;
    private int zone_count;
    private int build_count;
    private double totalArea;
    private double heatArea;
    private int totalUser;
    private int heatUser;

    public int getCompany_count() {
        return company_count;
    }

    public void setCompany_count(int company_count) {
        this.company_count = company_count;
    }

    public int getSource_plant_count() {
        return source_plant_count;
    }

    public void setSource_plant_count(int source_plant_count) {
        this.source_plant_count = source_plant_count;
    }

    public int getExchange_station_count() {
        return exchange_station_count;
    }

    public void setExchange_station_count(int exchange_station_count) {
        this.exchange_station_count = exchange_station_count;
    }

    public int getZone_count() {
        return zone_count;
    }

    public void setZone_count(int zone_count) {
        this.zone_count = zone_count;
    }

    public int getBuild_count() {
        return build_count;
    }

    public void setBuild_count(int build_count) {
        this.build_count = build_count;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getHeatArea() {
        return heatArea;
    }

    public void setHeatArea(double heatArea) {
        this.heatArea = heatArea;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    public int getHeatUser() {
        return heatUser;
    }

    public void setHeatUser(int heatUser) {
        this.heatUser = heatUser;
    }
}
