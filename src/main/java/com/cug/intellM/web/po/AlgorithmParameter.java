package com.cug.intellM.web.po;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import sun.nio.cs.StandardCharsets;

import java.io.UnsupportedEncodingException;

public class AlgorithmParameter {
    private Integer id;

    private Integer userId;

    private String modelId;

    private byte[] paraWeights;

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

    public byte[] getParaWeights() {
        return paraWeights;
    }

    public void setParaWeights(byte[] paraWeights) {
        this.paraWeights = paraWeights;
    }
    public String getParaWeightsStr() throws  UnsupportedEncodingException {
        return new String(paraWeights);
    }
}