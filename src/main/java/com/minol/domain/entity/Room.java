package com.minol.domain.entity;

import org.apache.poi.util.Internal;

import java.sql.Timestamp;

public class Room extends Unit {
    private Integer id;
    private Integer unit_id;
    private Integer r_name;
    /**
     * 楼层位置[1:顶层 2:中层 3:底层 4:阁楼 5:边层 6:边顶 7:边底 8:地下室]
     */
    private String location;
    private String user_code;
    private String host_name;
    private String contact_info;
    private Double room_area;
    private Double area;
    /**
     * 取暖对象性质（0：民用1:商用2：公建）
     */
    private Double user_type;
    //contract_num
    /**
     * 表具安装时间
     */
    private Timestamp install_time;
    /**
     * 采暖类型
     */
    private Integer heat_type;
    /**
     * 是否供暖 0:不供暖  1:供暖
     */
    private Integer is_supply;
    /**
     * 计费方式 [1:计量计费 0:面积计费]
     */
    private String charge_mode;
    /**
     * 热量表地址
     */
    private String heat_met_addr;
//    net_id
//            collector_id
//    heat_valve_addr
//            v_net_id
//    vcollector_id
//            notes
//    update_time
//            card_num
//    card_time
//            meter_protocol
//    valve_protocol
    /**
     * 预付费类型  1热量  2时间  3日期
     */
    private Integer prepay_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Integer unit_id) {
        this.unit_id = unit_id;
    }

    public Integer getR_name() {
        return r_name;
    }

    public void setR_name(Integer r_name) {
        this.r_name = r_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public Double getRoom_area() {
        return room_area;
    }

    public void setRoom_area(Double room_area) {
        this.room_area = room_area;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getUser_type() {
        return user_type;
    }

    public void setUser_type(Double user_type) {
        this.user_type = user_type;
    }

    public Timestamp getInstall_time() {
        return install_time;
    }

    public void setInstall_time(Timestamp install_time) {
        this.install_time = install_time;
    }

    public Integer getHeat_type() {
        return heat_type;
    }

    public void setHeat_type(Integer heat_type) {
        this.heat_type = heat_type;
    }

    public Integer getIs_supply() {
        return is_supply;
    }

    public void setIs_supply(Integer is_supply) {
        this.is_supply = is_supply;
    }

    public String getCharge_mode() {
        return charge_mode;
    }

    public void setCharge_mode(String charge_mode) {
        this.charge_mode = charge_mode;
    }

    public String getHeat_met_addr() {
        return heat_met_addr;
    }

    public void setHeat_met_addr(String heat_met_addr) {
        this.heat_met_addr = heat_met_addr;
    }

    public Integer getPrepay_type() {
        return prepay_type;
    }

    public void setPrepay_type(Integer prepay_type) {
        this.prepay_type = prepay_type;
    }
}
