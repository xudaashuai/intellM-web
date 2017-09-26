package com.cug.intellM.web.po;

public class EnglineerEvaluate {
    private Integer id;

    private String name;

    private Double avgEvaluation;

    private String avgArrivalTime;

    private String avgRepairTime;

    private String troubletypecode;

    private Integer totalNumber;

    private Integer servicetroublenum;

    private Integer servicetypenum;

    private Integer unfinished;

    private Double actualDistance;

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
        this.name = name == null ? null : name.trim();
    }

    public Double getAvgEvaluation() {
        return avgEvaluation;
    }

    public void setAvgEvaluation(Double avgEvaluation) {
        this.avgEvaluation = avgEvaluation;
    }

    public String getAvgArrivalTime() {
        return avgArrivalTime;
    }

    public void setAvgArrivalTime(String avgArrivalTime) {
        this.avgArrivalTime = avgArrivalTime == null ? null : avgArrivalTime.trim();
    }

    public String getAvgRepairTime() {
        return avgRepairTime;
    }

    public void setAvgRepairTime(String avgRepairTime) {
        this.avgRepairTime = avgRepairTime == null ? null : avgRepairTime.trim();
    }

    public String getTroubletypecode() {
        return troubletypecode;
    }

    public void setTroubletypecode(String troubletypecode) {
        this.troubletypecode = troubletypecode == null ? null : troubletypecode.trim();
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getServicetroublenum() {
        return servicetroublenum;
    }

    public void setServicetroublenum(Integer servicetroublenum) {
        this.servicetroublenum = servicetroublenum;
    }

    public Integer getServicetypenum() {
        return servicetypenum;
    }

    public void setServicetypenum(Integer servicetypenum) {
        this.servicetypenum = servicetypenum;
    }

    public Integer getUnfinished() {
        return unfinished;
    }

    public void setUnfinished(Integer unfinished) {
        this.unfinished = unfinished;
    }

    public Double getActualDistance() {
        return actualDistance;
    }

    public void setActualDistance(Double actualDistance) {
        this.actualDistance = actualDistance;
    }
}