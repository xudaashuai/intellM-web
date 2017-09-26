package com.cug.intellM.web.po;

public class TransformRule {
    private Integer transRule;

    private Integer transType;

    private String tablefield;

    private String judgeFormula;

    private String resultFormula;

    public Integer getTransRule() {
        return transRule;
    }

    public void setTransRule(Integer transRule) {
        this.transRule = transRule;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getTablefield() {
        return tablefield;
    }

    public void setTablefield(String tablefield) {
        this.tablefield = tablefield == null ? null : tablefield.trim();
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