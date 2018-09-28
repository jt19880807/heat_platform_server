package com.minol.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class Node_alerm extends Room {
    private Integer id;
    private String name;
    private Integer room_count;
    private String alerm_type;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp alerm_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom_count() {
        return room_count;
    }

    public void setRoom_count(Integer room_count) {
        this.room_count = room_count;
    }

    public String getAlerm_type() {
        return alerm_type;
    }

    public void setAlerm_type(String alerm_type) {
        this.alerm_type = alerm_type;
    }

    public Timestamp getAlerm_time() {
        return alerm_time;
    }

    public void setAlerm_time(Timestamp alerm_time) {
        this.alerm_time = alerm_time;
    }
}
