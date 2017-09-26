package com.cug.intellM.web.service;

import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.ModelAlgorithm;

import java.util.List;
import java.util.Map;

public interface ModelAlgorithmService {
    public Map<String, List<ModelAlgorithm>> getAllModelAndAlgorithm();

    public List<ModelAlgorithm> getAllAlgorithmByModelId(String id);

}