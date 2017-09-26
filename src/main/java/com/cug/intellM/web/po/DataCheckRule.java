package com.cug.intellM.web.po;

public class DataCheckRule {
    private Integer checkrule;

    private Integer checktype;

    private String tablename;

    private String fieldname;

    private String judgeFormula;

    private String resultFormula;

    public Integer getCheckrule() {
        return checkrule;
    }

    public void setCheckrule(Integer checkrule) {
        this.checkrule = checkrule;
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }

    public String getJudgeFormula() {
        return judgeFormula;
    }

    public void setJudgeFormula(String judgeFormula) {
        this.judgeFormula = judgeFormula == null ? null : judgeFormula.trim();
    }

    public String getResultFormula() {
        return resultFormula;
    }

    public void setResultFormula(String resultFormula) {
        this.resultFormula = resultFormula == null ? null : resultFormula.trim();
    }
}