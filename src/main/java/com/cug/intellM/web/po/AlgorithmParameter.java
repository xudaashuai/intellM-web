package com.cug.intellM.web.po;

public class AlgorithmParameter {
    private Integer id;

    private Integer userId;

    private String modelId;

    private String paraWeight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getParaWeight() {
        return paraWeight;
    }
    public int getModelPos(){
        return Integer.parseInt(modelId.split("#")[0]);
    }
    public int getAlgorithmPos(){
        return Integer.parseInt(modelId.split("#")[1]);
    }

    public void setParaWeight(String paraWeight) {
        this.paraWeight = paraWeight == null ? null : paraWeight.trim();
    }
}