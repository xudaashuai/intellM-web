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
	
	
	

	//Service层 利用dao层提供的基本功能     组织成更为丰富的服务
	@Autowired
	private UserMapper userMapper;//用户基本信息
		
	@Autowired
	private UserStrategyMapper userETL;//用户-ETL规则
	@Autowired
	private ETLMapper ETL;//ETL规则
	
	
	

   /*
	
	
	用户-ETL规则  具体实现
	
	
	 */
	
	
	//判断用户是否拥有指定id的ETL策略
	
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
	
			
	
	//根据账号 获取ID  失败返回-1
	

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
		
		//在ETL表中插入该ETL规则
		int ETLID=0;
		try
		{
		    ETL.insertSelective(etl);
		}catch(Exception e)
		{
			
			return false;
		}
		ETLID=etl.getId();
		//在用户-ETL表中插入记录
		UserStrategyKey newUserETL=new UserStrategyKey();
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return false;
		//配置用户-ETL信息
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
		//在 用户-ETL表中查出所有用户ETL规则id
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
		//从ETL策略表中依次读取出 所有属于该用户的ETL规则
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
		
		//验证是否存在该ETL规则
		if(this.HasETL(loginname, etlID)==false)
			return false;   //没有删除权限
		//先删除ETL表中指定 ETLID的数据
		
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
		//删除用户-ETL表中 数据
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
		//验证该用户是否拥有修改权限
		if(this.HasETL(loginname, theEtl.getId())==false)
			return false;
		//修改指定id的数据源	
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
		//验证该用户是否拥有修改权限
		if(this.HasETL(loginname, etlID)==false)
			return null;
		//获取指定id的ETL策略
		try
		{
			return ETL.selectByPrimaryKey(etlID);
		}catch(Exception e)
		{
			return null;
		}
		
	}
	
	

}
