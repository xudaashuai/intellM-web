package com.cug.intellM.web.po;

public class ETL {
    private Integer id;

    private String strategyname;

    private Integer extractresource;

    private String extratdetails;

    private Integer loadresource;

    private String loaddetails;

    private String executioncycle;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrategyname() {
        return strategyname;
    }

    public void setStrategyname(String strategyname) {
        this.strategyname = strategyname == null ? null : strategyname.trim();
    }

    public Integer getExtractresource() {
        return extractresource;
    }

    public void setExtractresource(Integer extractresource) {
        this.extractresource = extractresource;
    }

    public String getExtratdetails() {
        return extratdetails;
    }

    public void setExtratdetails(String extratdetails) {
        this.extratdetails = extratdetails == null ? null : extratdetails.trim();
    }

    public Integer getLoadresource() {
        return loadresource;
    }

    public void setLoadresource(Integer loadresource) {
        this.loadresource = loadresource;
    }

    public String getLoaddetails() {
        return loaddetails;
    }

    public void setLoaddetails(String loaddetails) {
        this.loaddetails = loaddetails == null ? null : loaddetails.trim();
    }

    public String getExecutioncycle() {
        return executioncycle;
    }

    public void setExecutioncycle(String executioncycle) {
        this.executioncycle = executioncycle == null ? null : executioncycle.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}