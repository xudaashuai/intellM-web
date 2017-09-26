package com.cug.intellM.web.controller;

import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    Map<Object,Object> addAl(@RequestParam String para,@RequestParam String modelId,@RequestParam int userId){
        // 获得所有模型与算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        AlgorithmParameter algorithmParameter=new AlgorithmParameter();
        algorithmParameter.setParaWeights(para.getBytes());
        algorithmParameter.setUserId(userId);
        algorithmParameter.setModelId(modelId);
        map.put("para",algorithmService.insertAlgorithmParameter2(userId,algorithmParameter));
        return map;
    }

}
