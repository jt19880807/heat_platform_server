package com.minol.domain.entity;

/**
 * 用热量
 */
public class UseOfHeat {
    private String buildName;
    private String userCode;
    private Double area;
    private String location;
    private String charge_mode;
    private Double useHeat;
    private Double avgHeat;
    private Double useFlow;

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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCharge_mode() {
        return charge_mode;
    }

    public void setCharge_mode(String charge_mode) {
        this.charge_mode = charge_mode;
    }

    public Double getUseHeat() {
        return useHeat;
    }

    public void setUseHeat(Double useHeat) {
        this.useHeat = useHeat;
    }

    public Double getAvgHeat() {
        return avgHeat;
    }

    public void setAvgHeat(Double avgHeat) {
        this.avgHeat = avgHeat;
    }

    public Double getUseFlow() {
        return useFlow;
    }

    public void setUseFlow(Double useFlow) {
        this.useFlow = useFlow;
    }
}
