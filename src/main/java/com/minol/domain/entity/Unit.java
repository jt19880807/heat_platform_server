package com.minol.domain.entity;

public class Unit extends Build {
    private Integer id;
    private Integer build_id;
    private Integer u_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuild_id() {
        return build_id;
    }

    public void setBuild_id(Integer build_id) {
        this.build_id = build_id;
    }

    public Integer getU_name() {
        return u_name;
    }

    public void setU_name(Integer u_name) {
        this.u_name = u_name;
    }
}
