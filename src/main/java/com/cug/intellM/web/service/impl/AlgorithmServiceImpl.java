package com.cug.intellM.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.AlgorithmParameterMapper;
import com.cug.intellM.web.dao.ModelAlgorithmMapper;
import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.AlgorithmParameterExample;
import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.ModelAlgorithmExample;
import com.cug.intellM.web.po.User;
import com.cug.intellM.web.po.UserExample;
import com.cug.intellM.web.service.AlgorithmService;

@Transactional
@Service
public class AlgorithmServiceImpl implements AlgorithmService
{
	
	

	//Service层 利用dao层提供的基本功能     组织成更为丰富的服务
	@Autowired
	private UserMapper userMapper;//用户基本信息
		
	@Autowired
	private AlgorithmParameterMapper theAlgorithmParameter;//算法参数
	@Autowired
	private ModelAlgorithmMapper theModelAlgorithm;//算法模型
	
	
	
	
	

	public int getUserID(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users=userMapper.selectByExample(itemsExample);
        if(users.size()==0)
        	return -1; 
        return users.get(0).getUserId();    
	}
	
	
	
	//获取当前所有算法模型
	public List<ModelAlgorithm> getModelAlgorithms() 
	{
		

		ModelAlgorithmExample oneExample=new ModelAlgorithmExample();
	
		List<ModelAlgorithm> modelAlgorithms;
		try
		{
			modelAlgorithms=theModelAlgorithm.selectByExample(oneExample);
		}catch(Exception e)
		{
			return null;
		}
		return modelAlgorithms;
		
		
	}

	public AlgorithmParameter getAlgorithmsParameter(String id) {
		AlgorithmParameterExample algorithmParameterExample=new AlgorithmParameterExample();
		algorithmParameterExample.createCriteria().andModelIdEqualTo(id);
		List<AlgorithmParameter> list= theAlgorithmParameter.selectByExample(algorithmParameterExample);
		if (list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

    public AlgorithmParameter getSystemAlgorithmsParameter(String id) {
        AlgorithmParameterExample algorithmParameterExample=new AlgorithmParameterExample();
        algorithmParameterExample.createCriteria().andModelIdEqualTo(id).andUserIdEqualTo(1);
        List<AlgorithmParameter> list= theAlgorithmParameter.selectByExampleWithBLOBs(algorithmParameterExample);
        if (list.size()==0){
            return null;
        }else{
            AlgorithmParameter algorithmParameter=list.get(0);
            return list.get(0);
        }
    }

	public AlgorithmParameter getAlgorithmsParameterById(int id) {

		//通过 算法ID查询 算法参数
		AlgorithmParameter theParameters;
		try
		{
			theParameters=theAlgorithmParameter.selectByPrimaryKey(id);
		}catch(Exception e)
		{
			return null;
		}
		return theParameters;
	}


	//插入算法参数
	public boolean insertAlgorithmParameter(String username, AlgorithmParameter theParameter) 
	{
		int theUserID=this.getUserID(username);
		if(theUserID==-1)
			return false;
		theParameter.setUserId(theUserID);//设置用户ID
		try
		{
			theAlgorithmParameter.insertSelective(theParameter);
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	public boolean insertAlgorithmParameter2(int User_ID, AlgorithmParameter theParameter) 
	{
		
		theParameter.setUserId(User_ID);//设置用户ID
		try
		{
			theAlgorithmParameter.insertSelective(theParameter);
		}catch(Exception e)
		{
			System.out.print("异常"+e);
			return false;
		}
		
		return true;
	}
	public List<AlgorithmParameter> getAlgorithmParameter(String username)
	{
		int theUserID=getUserID(username);
		if(theUserID==-1)
			return null;
		//在 算法参数表中查出用户的所有算法参数数据
		AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
		oneExample.or().andUserIdEqualTo(theUserID);
		List<AlgorithmParameter> theParameters;
		try
		{
			theParameters=theAlgorithmParameter.selectByExampleWithBLOBs(oneExample);
		}catch(Exception e)
		{
			return null;
		}
		return theParameters;
	}
	public List<AlgorithmParameter> getAlgorithmParameter2(int User_ID) 
	{
		//在 算法参数表中查出用户的所有算法参数数据
				AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
				oneExample.or().andUserIdEqualTo(User_ID);
				List<AlgorithmParameter> theParameters;
				try
				{
					theParameters=theAlgorithmParameter.selectByExampleWithBLOBs(oneExample);
				}catch(Exception e)
				{
					return null;
				}
				return theParameters;
	}
	public boolean deleteAlgorithmParameter(String username, int theParameterID) 
	{
		int theUserID=getUserID(username);
		if(theUserID==-1)
			return false;
		AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
		oneExample.or().andUserIdEqualTo(theUserID);
		oneExample.or().andIdEqualTo(theParameterID);
		try
		{
			theAlgorithmParameter.deleteByExample(oneExample);
		}catch(Exception e)
		{
			return false;
		}
		return true;
		
		
	}
	public boolean deleteAlgorithmParameter2(int User_ID, int theParameterID) 
	{
		
		AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
		oneExample.or().andUserIdEqualTo(User_ID);
		oneExample.or().andIdEqualTo(theParameterID);
		try
		{
			theAlgorithmParameter.deleteByExample(oneExample);
		}catch(Exception e)
		{
			return false;
		}
		return true;
		
		
	}
	public boolean updateAlgorithmParameter(AlgorithmParameter theParameter) 
	{
		
		AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
		oneExample.or().andUserIdEqualTo(theParameter.getUserId());
		oneExample.or().andIdEqualTo(theParameter.getId());
		try
		{
			theAlgorithmParameter.updateByExampleWithBLOBs(theParameter, oneExample);
		}catch(Exception e)
		{
			return false;
		}
		return true;
		
	}

}
