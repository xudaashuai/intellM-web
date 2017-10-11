package com.cug.intellM.web.controller;

import com.cug.intellM.web.po.*;
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
        // 用户所有自定义参数
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
        // 添加算法
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
        // 修改算法
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
        // 删除算法
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",modelService.deleteModelAlgorithm(alId));
        return map;
    }
    @RequestMapping(value = "/add_model",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> addModel(@RequestParam int userId,@RequestParam String modelName,@RequestParam String para){
        // 添加模型
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",modelService.addModel(userId,modelName,para));
        return map;
    }
    @RequestMapping(value = "/update_model",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> updateModel(@RequestParam int userId,@RequestParam int modelId,@RequestParam String para){
        // 修改模型
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",modelService.updateModel(userId,modelId,para));
        return map;
    }
    @RequestMapping(value = "/remove_model",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> removeModel(@RequestParam int userId,@RequestParam int modelId){
        // 删除模型
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",modelService.removeModel(modelId));
        return map;
    }
    @RequestMapping(value = "/add_para",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> addPara(@RequestParam int id,@RequestParam String alId,@RequestParam String para){
        // 添加自定义参数
        Map<Object,Object> map=new HashMap<Object,Object>();
        AlgorithmParameter algorithmParameter=new AlgorithmParameter();
        algorithmParameter.setParaWeight(para);
        algorithmParameter.setUserId(id);
        algorithmParameter.setModelId(alId);
        map.put("status",algorithmService.insertAlgorithmParameter2(id,algorithmParameter));
        return map;
    }
    @RequestMapping(value = "/update_para",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> updateModel(@RequestParam int id,@RequestParam int paraId,@RequestParam String alId,@RequestParam String para){
        // 添加自定义参数
        Map<Object,Object> map=new HashMap<Object,Object>();
        AlgorithmParameter algorithmParameter=new AlgorithmParameter();
        algorithmParameter.setParaWeight(para);
        algorithmParameter.setUserId(id);
        algorithmParameter.setId(paraId);
        algorithmParameter.setModelId(alId);
        map.put("status",algorithmService.updateAlgorithmParameter(algorithmParameter));
        return map;
    }
    @RequestMapping(value = "/remove_para",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> removePara(@RequestParam int id,@RequestParam int paraId){
        // 删除模型
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",algorithmService.deleteAlgorithmParameter2(id,paraId));
        return map;
    }
    @RequestMapping(value = "/get_etl_strategy",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> getETLStrategy(@RequestParam String loginname){
        // 获得用户所有数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("strategys",etlService.getETL(loginname));
        return map;
    }
    @RequestMapping(value = "/add_datasource",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> addDataSource(@RequestParam String loginname,@RequestParam String  username,@RequestParam String  url,@RequestParam String  password,@RequestParam int  type,@RequestParam int extract){
        // 添加数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        ETLDataSource etlDataSource=new ETLDataSource();
        etlDataSource.setPassword(password);
        etlDataSource.setUrl(url);
        etlDataSource.setType(type);
        etlDataSource.setUsername(username);
        etlDataSource.setExtract(extract);
        map.put("status",etlSourceService.insertETLSource(loginname,etlDataSource));
        return map;
    }
    @RequestMapping(value = "/get_etl_datasource",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> getDataSource(@RequestParam String loginname){
        // 获得用户所有数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("datasources",etlSourceService.getETLDataSource(loginname));
        return map;
    }
    @RequestMapping(value = "/test_database",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> testDatabase(String url, String username, String password){
        // 获得用户所有数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        Object r = dbService.testDatabase(url,username,password);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        if (r == null) {
            map.put("status", 1);
        }else{
            map.put("status",2);
            map.put("error",r.toString());
        }
        return map;
    }
    @RequestMapping(value = "/add_etl",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> addETL(@RequestParam String loginname,
                                     @RequestParam Integer extractresource,
                                     @RequestParam String strategyname,
                                     @RequestParam String extratdetails,
                                     @RequestParam Integer loadresource,
                                     @RequestParam String loaddetails,
                                     @RequestParam String executioncycle
    ){
        // 添加ETL
        Map<Object,Object> map=new HashMap<Object,Object>();
        ETL etl=new ETL();
        etl.setExecutioncycle(executioncycle);
        etl.setExtractresource(extractresource);
        etl.setExtratdetails(extratdetails);
        etl.setStrategyname(strategyname);
        etl.setLoaddetails(loaddetails);
        etl.setLoadresource(loadresource);
        map.put("status",etlService.insertETL(loginname,etl));
        return map;
    }    @RequestMapping(value = "/update_etl",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> updateETL(@RequestParam String loginname,
                                 @RequestParam Integer extractresource,
                                 @RequestParam Integer id,
                                     @RequestParam String strategyname,
                                     @RequestParam String extratdetails,
                                     @RequestParam Integer loadresource,
                                     @RequestParam String loaddetails,
                                     @RequestParam String executioncycle
            ){
        // 添加ETL
        Map<Object,Object> map=new HashMap<Object,Object>();
        ETL etl=new ETL();
        etl.setId(id);
        etl.setExecutioncycle(executioncycle);
        etl.setExtractresource(extractresource);
        etl.setExtratdetails(extratdetails);
        etl.setStrategyname(strategyname);
        etl.setLoaddetails(loaddetails);
        etl.setLoadresource(loadresource);
        map.put("status",etlService.updateETL(loginname,etl));
        return map;
    }

    @RequestMapping(value = "/remove_etl",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> getETLStrategy(@RequestParam String loginname,@RequestParam int id){
        // 获得用户所有数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("status",etlService.deleteETL(loginname,id));
        return map;
    }
    @RequestMapping(value = "/get_tables",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> getETLStrategy(@RequestParam int dataId){
        // 获得用户所有数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        ETLDataSource etlDataSource = etlSourceService.getETLDataSourceByid(dataId);
        map.put("status",true);
        map.put("tables", dbService.getTablesByURL(etlDataSource.getUrl(),etlDataSource.getUsername(),etlDataSource.getPassword()));
        return map;
    }
    @RequestMapping(value = "/get_columns",method = RequestMethod.POST)
    @ResponseBody
    Map<Object,Object> getETLStrategy(@RequestParam int dataId,@RequestParam String tableName){
        // 获得用户所有数据源
        Map<Object,Object> map=new HashMap<Object,Object>();
        ETLDataSource etlDataSource = etlSourceService.getETLDataSourceByid(dataId);
        map.put("status",true);
        map.put("columns", dbService.getCloumns(etlDataSource.getUrl(),etlDataSource.getUsername(),etlDataSource.getPassword(),tableName));
        return map;
    }

}
