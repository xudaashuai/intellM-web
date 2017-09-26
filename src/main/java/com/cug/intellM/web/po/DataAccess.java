package com.cug.intellM.web.po;

public class DataAccess {
    private Integer type;

    private String name;

    private Integer typeValue;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(Integer typeValue) {
        this.typeValue = typeValue;
    }
}