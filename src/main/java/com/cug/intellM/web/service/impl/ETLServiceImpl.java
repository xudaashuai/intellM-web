package com.cug.intellM.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.*;
import com.cug.intellM.web.po.*;

import com.cug.intellM.web.service.ETLService;



@Transactional
@Service
public class ETLServiceImpl  implements ETLService

{
	
	
	

	//Service�� ����dao���ṩ�Ļ�������     ��֯�ɸ�Ϊ�ḻ�ķ���
	@Autowired
	private UserMapper userMapper;//�û�������Ϣ
		
	@Autowired
	private UserStrategyMapper userETL;//�û�-ETL����
	@Autowired
	private ETLMapper ETL;//ETL����
	
	
	

   /*
	
	
	�û�-ETL����  ����ʵ��
	
	
	 */
	
	
	//�ж��û��Ƿ�ӵ��ָ��id��ETL����
	
	public boolean HasETL(String loginname,int etlID)
	{
		
		int theUserID=this.getUserID(loginname);
		if(theUserID==-1)
			return false;
		UserStrategyExample oneExample=new UserStrategyExample();
		oneExample.or().andUseridEqualTo(theUserID);
		oneExample.or().andStrategyidEqualTo(etlID);
		List<UserStrategyKey> ETLIDs;
		try
		{
			ETLIDs=userETL.selectByExample(oneExample);
			
		}catch(Exception e)
		{
			return false;
		}
		if(ETLIDs.size()==0)
			return false;
		else
			return true;
	}
	
			
	
	//�����˺� ��ȡID  ʧ�ܷ���-1
	

	public int getUserID(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users=userMapper.selectByExample(itemsExample);
        if(users.size()==0)
        	return -1; 
        return users.get(0).getUserId();    
	}
	

	public boolean insertETL(String loginname, ETL etl) 
	{
		
		//��ETL���в����ETL����
		int ETLID=0;
		try
		{
		    ETL.insertSelective(etl);
		}catch(Exception e)
		{
			
			return false;
		}
		ETLID=etl.getId();
		//���û�-ETL���в����¼
		UserStrategyKey newUserETL=new UserStrategyKey();
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return false;
		//�����û�-ETL��Ϣ
		newUserETL.setUserid(theUserID);
		newUserETL.setStrategyid(ETLID);
		try
		{
		       userETL.insertSelective(newUserETL);
		}catch(Exception e)
		{
			return false;
		}
		return true;
				
	}

	public List<ETL> getETL(String loginname)
	{
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return null;
		//�� �û�-ETL���в�������û�ETL����id
		UserStrategyExample oneExample=new UserStrategyExample();
		oneExample.or().andUseridEqualTo(theUserID);
		List<UserStrategyKey> userETLs;
		try
		{
			userETLs=userETL.selectByExample(oneExample);
		}catch(Exception e)
		{
			return null;
		}
		List<ETL> myETLS=new ArrayList<ETL>();
		//��ETL���Ա������ζ�ȡ�� �������ڸ��û���ETL����
		for(int i=0;i<userETLs.size();i++)
		{
			myETLS.add(ETL.selectByPrimaryKey( userETLs.get(i).getStrategyid()));
		}
		return  myETLS;
	}

	public boolean deleteETL(String loginname, int etlID) 
	{
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return false;
		
		//��֤�Ƿ���ڸ�ETL����
		if(this.HasETL(loginname, etlID)==false)
			return false;   //û��ɾ��Ȩ��
		//��ɾ��ETL����ָ�� ETLID������
		
		try
		{
			ETL.deleteByPrimaryKey(etlID);
		}catch(Exception e)
		{
			return false;
		}
		UserStrategyKey thekey=new UserStrategyKey();
		thekey.setStrategyid(etlID);
		thekey.setUserid(theUserID);
		//ɾ���û�-ETL���� ����
		try
		{
			userETL.deleteByPrimaryKey(thekey);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean updateETL(String loginname, ETL theEtl) 
	{
		
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return false;
		//��֤���û��Ƿ�ӵ���޸�Ȩ��
		if(this.HasETL(loginname, theEtl.getId())==false)
			return false;
		//�޸�ָ��id������Դ	
		try
		{
			ETL.updateByPrimaryKeySelective(theEtl);
		}catch(Exception e)
		{
			return false;
		}
		
		return true;

	}

	public ETL getETLbyid(String loginname, int etlID) 
	{

		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return null;
		//��֤���û��Ƿ�ӵ���޸�Ȩ��
		if(this.HasETL(loginname, etlID)==false)
			return null;
		//��ȡָ��id��ETL����
		try
		{
			return ETL.selectByPrimaryKey(etlID);
		}catch(Exception e)
		{
			return null;
		}
		
	}
	
	

}
