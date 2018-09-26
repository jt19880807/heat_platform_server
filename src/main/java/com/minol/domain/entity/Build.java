package com.minol.domain.entity;

public class Build extends Zone {
    private Integer id;
    private Integer zone_id;
    private String b_name;
    private Integer b_num;
    private Double area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZone_id() {
        return zone_id;
    }

    public void setZone_id(Integer zone_id) {
        this.zone_id = zone_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public Integer getB_num() {
        return b_num;
    }

    public void setB_num(Integer b_num) {
        this.b_num = b_num;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
