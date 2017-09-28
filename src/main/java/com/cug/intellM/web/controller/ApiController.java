package com.cug.intellM.web.controller;

import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.User;
import com.cug.intellM.web.service.ModelAlgorithmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/api")
public class ApiController extends BaseController{
    @RequestMapping(value = "/moals",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> loadInfo(String username){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        Map<String, List<ModelAlgorithm>> models=modelAlgorithmService.getAllModelAndAlgorithm();
        map.put("moals",models);
        return map;
    }
    @RequestMapping(value = "/user_paras",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> userParas(@RequestParam String username){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("paras",algorithmService.getAlgorithmParameter(username));
        return map;
    }

    @RequestMapping(value = "/get_para_by_model_id",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> systemAlPara(@RequestParam String modelId){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("para",algorithmService.getSystemAlgorithmsParameter(modelId));
        return map;
    }
    @RequestMapping(value = "/get_para_by_id",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> userAlPara(@RequestParam int id){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("para",algorithmService.getAlgorithmsParameterById(id));
        return map;
    }

    @RequestMapping(value = "/add_al",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> addAl(@RequestParam String para,
                             @RequestParam int modelId,
                             @RequestParam int userId,
                             @RequestParam String modelName,
                             @RequestParam String algorithmName){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        ModelAlgorithm modelAlgorithm = new ModelAlgorithm();
        modelAlgorithm.setModel(modelName);
        modelAlgorithm.setAlgorithm(algorithmName);
        String id = modelService.insertModelAlgorithm(modelId,modelAlgorithm);
        AlgorithmParameter algorithmParameter=new AlgorithmParameter();
        algorithmParameter.setModelId(id);
        algorithmParameter.setUserId(userId);
        algorithmParameter.setParaWeight(para);
        algorithmService.insertAlgorithmParameter2(userId,algorithmParameter);
        map.put("para",id);
        return map;
    }

    @RequestMapping(value = "/update_al",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> updateAl(@RequestParam String paraWeights,
                             @RequestParam String modelId,
                             @RequestParam int id,
                             @RequestParam int userId){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        AlgorithmParameter algorithmParameter=new AlgorithmParameter();
        algorithmParameter.setModelId(modelId);
        algorithmParameter.setId(id);
        algorithmParameter.setParaWeight(paraWeights);
        algorithmParameter.setUserId(userId);
        map.put("status",algorithmService.updateAlgorithmParameter(algorithmParameter));
        return map;
    }
    @RequestMapping(value = "/remove_al",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> removeAl(@RequestParam String alId){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",modelService.deleteModelAlgorithm(alId));
        return map;
    }


}
