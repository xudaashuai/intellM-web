package com.cug.intellM.web.service.impl;

import com.cug.intellM.web.dao.ModelAlgorithmMapper;
import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.ModelAlgorithmExample;
import com.cug.intellM.web.service.AlgorithmService;
import com.cug.intellM.web.service.ModelAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class ModelAlgorithmServiceImpl implements ModelAlgorithmService{
    @Autowired
    ModelAlgorithmMapper modelAlgorithmMapper;
    @Autowired
    AlgorithmService algorithmService;
    public Map<Integer,String> getAllModel() {
        ModelAlgorithmExample modelAlgorithmExample=new ModelAlgorithmExample();
        Map<Integer,String>  result= new HashMap<Integer, String>();
        List<ModelAlgorithm> list=modelAlgorithmMapper.selectByExample(modelAlgorithmExample);
        for (ModelAlgorithm modelAlgorithm : list) {
            result.put(Integer.parseInt(modelAlgorithm.getModelId().split("#")[0]),modelAlgorithm.getModel());
        }
        return result;
    }

    public Map<String, List<ModelAlgorithm>> getAllModelAndAlgorithm() {
        ModelAlgorithmExample modelAlgorithmExample=new ModelAlgorithmExample();
        Map<String, List<ModelAlgorithm>>  result= new HashMap<String, List<ModelAlgorithm>>();
        List<ModelAlgorithm> list=modelAlgorithmMapper.selectByExample(modelAlgorithmExample);
        for (ModelAlgorithm modelAlgorithm : list) {
            result.put(modelAlgorithm.getModel(),new ArrayList<ModelAlgorithm>());
        }
        for (ModelAlgorithm modelAlgorithm : list) {
            result.get(modelAlgorithm.getModel()).add(modelAlgorithm);
        }
        return result;
    }

    public List<ModelAlgorithm> getAllAlgorithmByModelId(String id) {
        ModelAlgorithmExample modelAlgorithmExample = new ModelAlgorithmExample();
        modelAlgorithmExample.createCriteria().andModelIdEqualTo(id);
        return modelAlgorithmMapper.selectByExample(modelAlgorithmExample);
    }
}
