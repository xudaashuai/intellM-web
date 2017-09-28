package com.cug.intellM.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.ModelAlgorithmMapper;
import com.cug.intellM.web.dao.ModelNumMapper;
import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.ModelAlgorithmExample;
import com.cug.intellM.web.po.ModelNum;
import com.cug.intellM.web.service.ModelService;

@Transactional
@Service
public class ModelServiceImpl implements ModelService
{
	
	@Autowired
	private ModelAlgorithmMapper modelAlgorithm;
	@Autowired
	private ModelNumMapper modelNumMapper;
	public List<ModelAlgorithm> getModelAlgorithms() 
	{
		ModelAlgorithmExample oneExample=new ModelAlgorithmExample();
		List<ModelAlgorithm> modelAlgorithms;
		try
		{
			modelAlgorithms=modelAlgorithm.selectByExample(oneExample);
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
				modelAlgorithm.insertSelective(onemodel);
				
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
				modelAlgorithm.insertSelective(onemodel);
			}catch(Exception e)
			{
				return null;
			}
			return Model_ID;
		}
			
		
	}

	public int insertModelAlgorithm(ModelAlgorithm onemodel) {
		return modelAlgorithm.insertSelective(onemodel);
	}

	public boolean deleteModelAlgorithm(String Model_ID)
	{
		try
		{
			modelAlgorithm.deleteByPrimaryKey(Model_ID);
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
			modelAlgorithm.updateByPrimaryKey(newModel);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public ModelAlgorithm getByModelID(String Model_ID) {
		try
		{
			return modelAlgorithm.selectByPrimaryKey(Model_ID);
		}catch(Exception e)
		{
			return null;
		}
	}
		
		
		

}
