package com.minol.domain.entity;

public class MeterECA extends MeterData {
    private Double maxHeat;
    private Double minHeat;
    private Double useHeat;
    private Double avgHeat;
    private Double avg_in_temp;
    private Double avg_out_temp;

    public Double getMaxHeat() {
        return maxHeat;
    }

    public void setMaxHeat(Double maxHeat) {
        this.maxHeat = maxHeat;
    }

    public Double getMinHeat() {
        return minHeat;
    }

    public void setMinHeat(Double minHeat) {
        this.minHeat = minHeat;
    }

    public Double getAvgHeat() {
        return avgHeat;
    }

    public void setAvgHeat(Double avgHeat) {
        this.avgHeat = avgHeat;
    }

    public Double getAvg_in_temp() {
        return avg_in_temp;
    }

    public void setAvg_in_temp(Double avg_in_temp) {
        this.avg_in_temp = avg_in_temp;
    }

    public Double getAvg_out_temp() {
        return avg_out_temp;
    }

    public void setAvg_out_temp(Double avg_out_temp) {
        this.avg_out_temp = avg_out_temp;
    }

    public Double getUseHeat() {
        return useHeat;
    }

    public void setUseHeat(Double useHeat) {
        this.useHeat = useHeat;
    }
}
