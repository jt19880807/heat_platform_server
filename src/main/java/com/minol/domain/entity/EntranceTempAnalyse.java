package com.minol.domain.entity;

/**
 * 进水温度分析
 */
public class EntranceTempAnalyse {
    private Integer low_40;
    private Integer low_50;
    private Integer low_60;
    private Integer up_60;

    public Integer getLow_40() {
        return low_40;
    }

    public void setLow_40(Integer low_40) {
        this.low_40 = low_40;
    }

    public Integer getLow_50() {
        return low_50;
    }

    public void setLow_50(Integer low_50) {
        this.low_50 = low_50;
    }

    public Integer getLow_60() {
        return low_60;
    }

    public void setLow_60(Integer low_60) {
        this.low_60 = low_60;
    }

    public Integer getUp_60() {
        return up_60;
    }

    public void setUp_60(Integer up_60) {
        this.up_60 = up_60;
    }
}
