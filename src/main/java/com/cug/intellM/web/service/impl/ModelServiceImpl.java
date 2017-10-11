package com.cug.intellM.web.service.impl;

import java.util.List;

import com.cug.intellM.web.dao.AlgorithmParameterMapper;
import com.cug.intellM.web.po.*;
import com.cug.intellM.web.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.ModelAlgorithmMapper;
import com.cug.intellM.web.dao.ModelNumMapper;
import com.cug.intellM.web.service.ModelService;

@Transactional
@Service
public class ModelServiceImpl implements ModelService
{
	
	@Autowired
	private ModelAlgorithmMapper modelAlgorithmMapper;
    @Autowired
    private ModelNumMapper modelNumMapper;
    @Autowired
    private AlgorithmService algorithmService;
    @Autowired
    private AlgorithmParameterMapper algorithmParameterMapper;
	public List<ModelAlgorithm> getModelAlgorithms() 
	{
		ModelAlgorithmExample oneExample=new ModelAlgorithmExample();
		List<ModelAlgorithm> modelAlgorithms;
		try
		{
			modelAlgorithms= modelAlgorithmMapper.selectByExample(oneExample);
		}catch(Exception e)
		{
			return null;
		}
		return modelAlgorithms;
		
	}
	public String insertModelAlgorithm(int classifcation, ModelAlgorithm onemodel)
	{
		ModelNum result=null;
		try
		{
		    result=modelNumMapper.selectByPrimaryKey(classifcation);
		}catch(Exception e)
		{
			return null;
		}
		if(result==null)
		{
			//��û���������½�һ����𣬷��ص�ǰ�����Ŀ��1
			ModelNum record=new ModelNum();
			record.setModel(classifcation);
			record.setNum(1);
			String Model_ID=classifcation+"#"+"1";
			onemodel.setModelId(Model_ID);
			try
			{
				modelNumMapper.insertSelective(record);
				//ͬʱ��ModelAlgorithm�в����¼�¼
				modelAlgorithmMapper.insertSelective(onemodel);
				
			}catch(Exception e)
			{
				return null;
			}
			return Model_ID;
		}
		else
		{
			int Num=result.getNum();
			Num++;
			String Model_ID=classifcation+"#"+Num;
			onemodel.setModelId(Model_ID);
			ModelNum record=new ModelNum();
			record.setModel(classifcation);
			record.setNum(Num);
			try
			{
				//����modelNum����ModelAlgorithm���
				modelNumMapper.updateByPrimaryKey(record);
				modelAlgorithmMapper.insertSelective(onemodel);
			}catch(Exception e)
			{
				return null;
			}
			return Model_ID;
		}
			
		
	}

	public int insertModelAlgorithm(ModelAlgorithm onemodel) {
		return modelAlgorithmMapper.insertSelective(onemodel);
	}

	public boolean deleteModelAlgorithm(String Model_ID)
	{
		try
		{
			modelAlgorithmMapper.deleteByPrimaryKey(Model_ID);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public boolean updateModelAlgorithm(ModelAlgorithm newModel) 
	{
		try
		{
			modelAlgorithmMapper.updateByPrimaryKey(newModel);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public ModelAlgorithm getByModelID(String Model_ID) {
		try
		{
			return modelAlgorithmMapper.selectByPrimaryKey(Model_ID);
		}catch(Exception e)
		{
			return null;
		}
	}
	public boolean addModel(int userId,String model,String para) {
		ModelNum modelNum=new ModelNum();
		modelNum.setNum(0);
		int t = modelNumMapper.countByExample(new ModelNumExample())+1;
		modelNum.setModel(t);
        modelNumMapper.insertSelective(modelNum);
		ModelAlgorithm modelAlgorithm=new ModelAlgorithm();
		modelAlgorithm.setModel(model);
		modelAlgorithm.setAlgorithm("参数列表");
		modelAlgorithm.setModelId(t+"#"+"0");
		modelAlgorithmMapper.insert(modelAlgorithm);
        AlgorithmParameter algorithmParameter = new AlgorithmParameter();
        algorithmParameter.setModelId(""+t);
        algorithmParameter.setParaWeight(para);
        algorithmParameter.setModelId(t+"#"+"0");
        return algorithmService.insertAlgorithmParameter2(userId,algorithmParameter);
	}

	public boolean removeModel(int modelId) {
	    //todo
		int t = modelNumMapper.countByExample(new ModelNumExample());
		for (int i = 0; i < t; i++) {
			deleteModelAlgorithm(modelId+"#"+i);
		}
		return false;
	}

	public boolean updateModel(int userId,int modelId,String para) {
        AlgorithmParameterExample algorithmParameterExample=new AlgorithmParameterExample();
        algorithmParameterExample.createCriteria().andModelIdEqualTo(modelId+"#"+0);
        AlgorithmParameter algorithmParameter = (algorithmParameterMapper.selectByExample(algorithmParameterExample).get(0));
        algorithmParameter.setParaWeight(para);
        return algorithmService.updateAlgorithmParameter( algorithmParameter);
    }



}
