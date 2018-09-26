package com.minol.domain.entity;

public class MeterECA extends MeterData {
    private Double maxHeat;
    private Double minHeat;
    private Double avgHeat;

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
}
