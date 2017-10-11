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
	
	

	//Service�� ����dao���ṩ�Ļ�������     ��֯�ɸ�Ϊ�ḻ�ķ���
	@Autowired
	private UserMapper userMapper;//�û�������Ϣ
		
	@Autowired
	private AlgorithmParameterMapper theAlgorithmParameter;//�㷨����
	@Autowired
	private ModelAlgorithmMapper theModelAlgorithm;//�㷨ģ��
	
	
	
	
	

	public int getUserID(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users=userMapper.selectByExample(itemsExample);
        if(users.size()==0)
        	return -1; 
        return users.get(0).getUserId();    
	}
	
	
	
	//��ȡ��ǰ�����㷨ģ��
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
        List<AlgorithmParameter> list= theAlgorithmParameter.selectByExample(algorithmParameterExample);
        if (list.size()==0){
            return null;
        }else{
            AlgorithmParameter algorithmParameter=list.get(0);
            return list.get(0);
        }
    }

	public AlgorithmParameter getAlgorithmsParameterById(int id) {

		//ͨ�� �㷨ID��ѯ �㷨����
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

	//�����㷨����
	public boolean insertAlgorithmParameter(String username, AlgorithmParameter theParameter)
	{
		int theUserID=this.getUserID(username);
		if(theUserID==-1)
			return false;
		theParameter.setUserId(theUserID);//�����û�ID
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

		theParameter.setUserId(User_ID);//�����û�ID
		try
		{
			theAlgorithmParameter.insertSelective(theParameter);
		}catch(Exception e)
		{
			System.out.print("�쳣"+e);
			return false;
		}

		return true;
	}
	public List<AlgorithmParameter> getAlgorithmParameter(String username)
	{
		int theUserID=getUserID(username);
		if(theUserID==-1)
			return null;
		//�� �㷨�������в���û��������㷨��������
		AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
		oneExample.or().andUserIdEqualTo(theUserID);
		List<AlgorithmParameter> theParameters;
		try
		{
			theParameters=theAlgorithmParameter.selectByExample(oneExample);
		}catch(Exception e)
		{
			return null;
		}
		return theParameters;
	}
	public List<AlgorithmParameter> getAlgorithmParameter2(int User_ID)
	{
		//�� �㷨�������в���û��������㷨��������
		System.out.println("Ī���ǣ���");
		AlgorithmParameterExample oneExample=new AlgorithmParameterExample();
		oneExample.or().andUserIdEqualTo(User_ID);
		List<AlgorithmParameter> theParameters;
		try
		{
			theParameters=theAlgorithmParameter.selectByExample(oneExample);
		}catch(Exception e)
		{
			System.out.println("�쳣"+e);
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
		oneExample.createCriteria().andIdEqualTo(theParameterID);
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
		oneExample.createCriteria().andIdEqualTo(theParameter.getId());
		try
		{
			theAlgorithmParameter.updateByExampleSelective(theParameter, oneExample);
		}catch(Exception e)
		{
			return false;
		}
		return true;

	}

}
