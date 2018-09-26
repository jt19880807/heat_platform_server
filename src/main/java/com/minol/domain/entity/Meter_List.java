package com.minol.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class Meter_List extends Build {
    private Integer id;
    private Integer zone_id;
    /**
     * 表具地址
     */
    private String meter_addr;
    /**
     * 表具名称
     */
    private String meter_name;
    /**
     * meter_manufact
     */
    private String meter_manufact;
    /**
     * 表具协议
     */
    private String meter_protocol;
    /**
     * meter_protocol_num
     */
    private Integer meter_protocol_num;
    /**
     * 表具信息备注
     */
    private String meter_note;
    /**
     * 集抄器网络号
     */
    private Integer net_num;
    /**
     * 表具使用起始时间
     */
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp meter_starttime;
    /**
     * 表具使用截止时间
     */
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp meter_stoptime;
    /**
     * 0是不分摊，1是分摊
     */
    private Integer meter_isshare;
    /**
     * 分摊时间
     */
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp meter_sharetime;
    /**
     * 分摊模式[0：暂不分摊、1：自动分摊、2：计划分摊、3：即时分摊、4：现场分摊]
     */
    private Integer share_mode;
    /**
     * 分摊方式[0：通断时间面积法、1：温度面积法]
     */
    private InternalError share_method;
    /**
     * 分摊数据开始时间
     */
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp share_start_time;
    /**
     * 分摊数据结束时间
     */
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp share_end_time;
    /**
     * 计划分摊时间
     */
    @JSONField(format="yy-MM-dd HH:mm:ss")
    private Timestamp share_plan_time;
    /**
     * 分摊周期模式[0:小时、1：天、2：周、3：月]
     */
    private Integer share_period_mode;
    /**
     * 分摊周期，*天[当分摊模式为小时或者天：0，周：1-7，月：1-31]
     */
    private Integer share_period_day;
    /**
     * 分摊周期，*小时[当分摊模式为小时：2、4、6、8、12，天、周、月：0-23]
     */
    private Integer share_period_time;
    /**
     * 分摊是否完成[0:未完成、1:完成]
     */
    private Integer is_share_over;
    /**
     * 分支表覆盖面积
     */
    private Double heat_area;

    /**
     * 1：小区总表
     2：楼宇栋表
     3：单元总表
     */
    private String meter_type;

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

    public String getMeter_addr() {
        return meter_addr;
    }

    public void setMeter_addr(String meter_addr) {
        this.meter_addr = meter_addr;
    }

    public String getMeter_name() {
        return meter_name;
    }

    public void setMeter_name(String meter_name) {
        this.meter_name = meter_name;
    }

    public String getMeter_manufact() {
        return meter_manufact;
    }

    public void setMeter_manufact(String meter_manufact) {
        this.meter_manufact = meter_manufact;
    }

    public String getMeter_protocol() {
        return meter_protocol;
    }

    public void setMeter_protocol(String meter_protocol) {
        this.meter_protocol = meter_protocol;
    }

    public Integer getMeter_protocol_num() {
        return meter_protocol_num;
    }

    public void setMeter_protocol_num(Integer meter_protocol_num) {
        this.meter_protocol_num = meter_protocol_num;
    }

    public String getMeter_note() {
        return meter_note;
    }

    public void setMeter_note(String meter_note) {
        this.meter_note = meter_note;
    }

    public Integer getNet_num() {
        return net_num;
    }

    public void setNet_num(Integer net_num) {
        this.net_num = net_num;
    }

    public Timestamp getMeter_starttime() {
        return meter_starttime;
    }

    public void setMeter_starttime(Timestamp meter_starttime) {
        this.meter_starttime = meter_starttime;
    }

    public Timestamp getMeter_stoptime() {
        return meter_stoptime;
    }

    public void setMeter_stoptime(Timestamp meter_stoptime) {
        this.meter_stoptime = meter_stoptime;
    }

    public Integer getMeter_isshare() {
        return meter_isshare;
    }

    public void setMeter_isshare(Integer meter_isshare) {
        this.meter_isshare = meter_isshare;
    }

    public Timestamp getMeter_sharetime() {
        return meter_sharetime;
    }

    public void setMeter_sharetime(Timestamp meter_sharetime) {
        this.meter_sharetime = meter_sharetime;
    }

    public Integer getShare_mode() {
        return share_mode;
    }

    public void setShare_mode(Integer share_mode) {
        this.share_mode = share_mode;
    }

    public InternalError getShare_method() {
        return share_method;
    }

    public void setShare_method(InternalError share_method) {
        this.share_method = share_method;
    }

    public Timestamp getShare_start_time() {
        return share_start_time;
    }

    public void setShare_start_time(Timestamp share_start_time) {
        this.share_start_time = share_start_time;
    }

    public Timestamp getShare_end_time() {
        return share_end_time;
    }

    public void setShare_end_time(Timestamp share_end_time) {
        this.share_end_time = share_end_time;
    }

    public Timestamp getShare_plan_time() {
        return share_plan_time;
    }

    public void setShare_plan_time(Timestamp share_plan_time) {
        this.share_plan_time = share_plan_time;
    }

    public Integer getShare_period_mode() {
        return share_period_mode;
    }

    public void setShare_period_mode(Integer share_period_mode) {
        this.share_period_mode = share_period_mode;
    }

    public Integer getShare_period_day() {
        return share_period_day;
    }

    public void setShare_period_day(Integer share_period_day) {
        this.share_period_day = share_period_day;
    }

    public Integer getShare_period_time() {
        return share_period_time;
    }

    public void setShare_period_time(Integer share_period_time) {
        this.share_period_time = share_period_time;
    }

    public Integer getIs_share_over() {
        return is_share_over;
    }

    public void setIs_share_over(Integer is_share_over) {
        this.is_share_over = is_share_over;
    }

    public Double getHeat_area() {
        return heat_area;
    }

    public void setHeat_area(Double heat_area) {
        this.heat_area = heat_area;
    }

    public String getMeter_type() {
        return meter_type;
    }

    public void setMeter_type(String meter_type) {
        this.meter_type = meter_type;
    }
}
