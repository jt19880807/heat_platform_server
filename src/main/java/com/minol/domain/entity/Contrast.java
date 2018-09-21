package com.minol.domain.entity;

/**
 * 用热量
 */
public class Contrast {
    private String buildName;
    private String userCode;
    private Double currentHeat;
    private Double lastHeat;
    private Double beforeHeat;
    private Double currentAvgHeat;
    private Double lastAvgHeat;
    private Double beforeAvgHeat;

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Double getCurrentHeat() {
        return currentHeat;
    }

    public void setCurrentHeat(Double currentHeat) {
        this.currentHeat = currentHeat;
    }

    public Double getLastHeat() {
        return lastHeat;
    }

    public void setLastHeat(Double lastHeat) {
        this.lastHeat = lastHeat;
    }

    public Double getBeforeHeat() {
        return beforeHeat;
    }

    public void setBeforeHeat(Double beforeHeat) {
        this.beforeHeat = beforeHeat;
    }

    public Double getCurrentAvgHeat() {
        return currentAvgHeat;
    }

    public void setCurrentAvgHeat(Double currentAvgHeat) {
        this.currentAvgHeat = currentAvgHeat;
    }

    public Double getLastAvgHeat() {
        return lastAvgHeat;
    }

    public void setLastAvgHeat(Double lastAvgHeat) {
        this.lastAvgHeat = lastAvgHeat;
    }

    public Double getBeforeAvgHeat() {
        return beforeAvgHeat;
    }

    public void setBeforeAvgHeat(Double beforeAvgHeat) {
        this.beforeAvgHeat = beforeAvgHeat;
    }
}
