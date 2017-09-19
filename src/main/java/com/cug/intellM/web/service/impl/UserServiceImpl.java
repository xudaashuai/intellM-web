package com.cug.intellM.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.*;
import com.cug.intellM.web.po.*;

import com.cug.intellM.web.service.UserService;

/** 
 * 
 */

@Transactional
@Service
public class UserServiceImpl implements UserService
{

	
	
	//Service层 利用dao层提供的基本功能     组织成更为丰富的服务
	@Autowired
	private UserMapper userMapper;//用户基本信息
	private UserSourceMapper userSource;//用户-数据源
	private ETLDataSourceMapper ETLDataSource;//数据源
	private ETLMapper ETL;//ETL规则
	private UserStrategyMapper userETL;//用户-ETL规则
	private DataCheckRuleMapper dataCheckRule;//检查规则
	private StrategyCheckMapper ETLcheckRule;//ETL-检查规则
	
	
	//检查账号是否已经存在

	public boolean checkloginName(String loginName)
	{
		
		//构造查询条件
		    UserExample itemsExample = new UserExample();
	        itemsExample.or().andLoginnameEqualTo(loginName);
	        List<User> users;
	        try
	        {
	        	users=userMapper.selectByExample(itemsExample);
	        }catch(Exception e)
	        {
	        	return true;    //异常处理
	        }
	        if(users.size()==0)
	        	return false;    //账号未被注册
	        else
	        	return true;      //账号已被注册
	 
	}
	
	//检查用户账号 密码是否正确
	
	
	public boolean checkPassword(String loginName,String Password)
	{
		
		    UserExample itemsExample = new UserExample();
	        itemsExample.or().andLoginnameEqualTo(loginName);
	        itemsExample.or().andPasswordEqualTo(Password);
	        List<User> users;
	        try
	        {
	            users=userMapper.selectByExample(itemsExample);
	            
	        }catch(Exception e)
	        {
	        	return false;  //出现异常返回false
	        }
	        
	        if(users.size()==0)
	        	return false;    
	        else
	        	return true;      //验证成功
		
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
	
	//检查用户是否已经登陆
	public boolean IsLogin(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users;
        try
        {
           users=userMapper.selectByExample(itemsExample);
           
        }catch(Exception e)
        {
        	return true;
        }
        if(users.size()==0)
        	return true; 
        {
        	if(users.get(0).getState()==0)
        		return false;
        	else
        		return true;   //已经登陆
        	
        }
       
		
	}
	
	//设置用户登陆状态（未登录0  已经登陆1）  设置失败返回false
	public boolean setState(String loginname,int thestate)
	{
		  int userID=this.getUserID(loginname);
		  if(userID==-1)
			  return false;
		  User user=new User();
		  user.setState(thestate);
		  try
		  {
			  userMapper.updateByPrimaryKeySelective(user);
		  }catch(Exception e)
		  {
			  return false;
		  }
		  return true;
		
	}
	//验证成功后，调用此函数获取用户类型 0 普通用户 1 管理员
	
	public int getUser_Type(String loginName)
	{
		    UserExample itemsExample = new UserExample();
	        itemsExample.or().andLoginnameEqualTo(loginName);
	        List<User> users=userMapper.selectByExample(itemsExample);
	        if(users.size()==0)
	        	return 0; 
	        return users.get(0).getUserType();    
	}
	
	
	
	
	/*
	 * 
	 * 
	用户基本信息管理
	 */
	
	
	//根据账号获取用户基本信息  以User返回
	
	public User getUserByLoginName(String loginname)
	{
		
		    UserExample itemsExample = new UserExample();
		    List<User> users;
	        try
	        {
	            users=userMapper.selectByExample(itemsExample);
	        }catch(Exception e)
	        {
	        	return null;
	        }
	        if(users.size()==0)
	        	return null; 
	        return users.get(0);    
		
	}
		
		
	
	//新增一个普通用户   失败返回false
	
	public boolean insertUser(String Name,int Sex,String LoginName,String password,String Dept_ID)
	{
		//若已经存在 返回false
				if(this.checkloginName(LoginName)==true)
					return false;
				User newuser=new User();
				newuser.setName(Name);
				newuser.setSex(Sex);
				newuser.setLoginname(LoginName);
				newuser.setPassword(password);
				newuser.setDeptId(Dept_ID);
				newuser.setUserType(0);  //0普通用户
				int result=0;
				try
				{
				       result=userMapper.insertSelective(newuser);
				}catch(Exception e)
				{
					return false;
				}
				System.out.println(result);
				return true;
		
		
		
	}
	//新增一个管理员    失败返回false
	
	public boolean insertAdministrator(String Name,int Sex,String LoginName,String password,String Dept_ID)
	{
		
		      //若已经存在 返回false
				if(this.checkloginName(LoginName)==true)
					return false;
				User newuser=new User();
				newuser.setName(Name);
				newuser.setSex(Sex);
				newuser.setLoginname(LoginName);
				newuser.setPassword(password);
				newuser.setDeptId(Dept_ID);
				newuser.setUserType(1);  //0普通用户
				int result=0;
				try
				{
				       result=userMapper.insertSelective(newuser);
				}catch(Exception e)
				{
					return false;
				}
				System.out.println(result);
				return true;
		
	
	}
	
	
	//修改指定账号的昵称   失败返回false
	public boolean updateName(String loginname,String newname)
	{
		//若账号不存在 返回false
		if(this.checkloginName(loginname)==false)
			return false;
		
		//设置更新条件
		User user=new User();
		user.setName(newname);
		UserExample itemsExample = new UserExample();
	    itemsExample.or().andLoginnameEqualTo(loginname);
	    try
	    {
	    	userMapper.updateByExampleSelective(user, itemsExample);   //只更新Name字段
	    }catch(Exception e)
	    {
	    	return false;
	    }
		return true;
		
	}
	
	//修改密码  失败返回false
	public boolean updatePassword(String loginname,String password)
	{

		       //若账号不存在 返回false
				if(this.checkloginName(loginname)==false)
					return false;
				
				//设置更新条件
				User user=new User();
				user.setPassword(password);
				UserExample itemsExample = new UserExample();
			    itemsExample.or().andLoginnameEqualTo(loginname);
			    try
			    {
			    	userMapper.updateByExampleSelective(user, itemsExample);   //只更新Password字段
			    }catch(Exception e)
			    {
			    	return false;
			    }
				return true;
	}
	//修改用户部分信息
	public boolean updateUserData(String loginname,User user)
	{

		       //若账号不存在 返回false
				if(this.checkloginName(loginname)==false)
					return false;
				
				//设置更新条件
				
				UserExample itemsExample = new UserExample();
			    itemsExample.or().andLoginnameEqualTo(loginname);
			    try
			    {
			    	userMapper.updateByExampleSelective(user, itemsExample);   //只更新User不为Null字段
			    }catch(Exception e)
			    {
			    	return false;
			    }
				return true;
	}
	
	
	
	
	
	/*
	 * 
	 * 
	 用户-数据源具体实现
	 
	 
	 */
	
	
	
	
	
	
    //指定用户  新增ETL数据源   失败返回false   （不用指定ETLSource主健 --自增主键）
	public boolean insertETLSource(String loginname, ETLDataSource etlSource) 
	{
		System.out.print(loginname);
		//若账号不存在 返回false
		if(this.checkloginName(loginname)==false)
		{
			
			System.out.print("无此用户？？");
			return false;
		}
		//在数据源表中插入该数据源
		System.out.print(etlSource.getUrl());
		int SourceID=0;
		try
		{
		      SourceID= ETLDataSource.insertSelective(etlSource);
		      
		}catch(Exception e)
		{
			
			System.out.print("出现sql异常");
			System.out.print(e);
			return false;
		}
		//在用户-数据源表中插入记录
		UserSource newUserSource=new UserSource();
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
		{
			System.out.print("无此用户？");
		
			return false;
		}
		newUserSource.setUserid(theUserID);
		newUserSource.setSourceid(SourceID);
		try
		{
		       userSource.insertSelective(newUserSource);
		}catch(Exception e)
		{
			System.out.print("插入异常");
			return false;
		}
		return true;
			
	}
	
	//返回指定用户所有数据源  List<ETLSource>
	public List<ETLDataSource> getETLDataSource(String loginname)
	{
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return null;
		//在 用户-数据源表中查出所有用户数据源id
		UserSourceExample oneExample=new UserSourceExample();
		oneExample.or().andUseridEqualTo(theUserID);
		List<UserSource> sourceIDs;
		try
		{
			sourceIDs=userSource.selectByExample(oneExample);
		}catch(Exception e)
		{
			System.out.print("出现异常");
			return null;
		}
		List<ETLDataSource> Sources=new ArrayList<ETLDataSource>();
		for(int i=0;i<sourceIDs.size();i++)
		{
			Sources.add(ETLDataSource.selectByPrimaryKey( sourceIDs.get(i).getSourceid()));
		}
		return  Sources;
			
	}
	
	//用户删除指定id的数据源
	public boolean deleteETLDataSource(String loginname,int SourceID)
	{

		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return false;
		
		//验证是否存在该数据源
		//在 用户-数据源表中查出所有用户数据源id
		UserSourceExample oneExample=new UserSourceExample();
		oneExample.or().andUseridEqualTo(theUserID);
		oneExample.or().andSourceidEqualTo(SourceID);
		List<UserSource> sourceIDs;
		try
		{
			sourceIDs=userSource.selectByExample(oneExample);
			
		}catch(Exception e)
		{
			System.out.print("出现异常-_-");
			return false;
		}
		if(sourceIDs.size()==0)
			return false;
		//先删除 数据源表中指定 SourceID的数据
		
		try
		{
			ETLDataSource.deleteByPrimaryKey(sourceIDs.get(0).getSourceid());
		}catch(Exception e)
		{
			return false;
		}
		
		//删除用户-数据源表中 数据
		try
		{
			userSource.deleteByExample(oneExample);
		}catch(Exception e)
		{
			return false;
		}
		return true;
			
	}
	
	//用户修改指定数据源  指定修改后的ETLSource
	public boolean updateETLDataSource(String loginname,ETLDataSource thesource)
	{
		int theUserID=getUserID(loginname);
		if(theUserID==-1)
			return false;
		//验证该用户是否存在 指定数据源
		UserSourceExample oneExample=new UserSourceExample();
		oneExample.or().andUseridEqualTo(theUserID);
		oneExample.or().andSourceidEqualTo(thesource.getId());
		List<UserSource> sourceIDs;
		try
		{
			sourceIDs=userSource.selectByExample(oneExample);
		}catch(Exception e)
		{
			return false;
		}
		if(sourceIDs.size()==0)
			return false;
		
		//修改指定id的数据源	
		try
		{
			ETLDataSource.updateByPrimaryKeySelective(thesource);
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
		
	}
	
	/*
	
	
	用户-ETL规则  具体实现
	
	
	 */

	public boolean insertETL(String loginname, ETL etl) 
	{
		if(this.checkloginName(loginname)==false)
			return false;
		if(etl==null)
			System.out.print("空对象");
		//在ETL表中插入该ETL规则
		int ETLID=0;
		try
		{
		    ETLID= ETL.insertSelective(etl);
		}catch(Exception e)
		{
			System.out.print("异常："+e);
			return false;
		}
		//在用户-ETL表中插入记录
		UserStrategy newUserETL=new UserStrategy();
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
		List<UserStrategy> userETLs;
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
		//在 用户-ETL表中查出用户ETL的id
		UserStrategyExample oneExample=new UserStrategyExample();
		oneExample.or().andUseridEqualTo(theUserID);
		oneExample.or().andStrategyidEqualTo(etlID);
		List<UserStrategy> ETLIDs;
		try
		{
			ETLIDs=userETL.selectByExample(oneExample);
			
		}catch(Exception e)
		{
			return false;
		}
		if(ETLIDs.size()==0)
			return false;
		//先删除ETL表中指定 ETLID的数据
		
		try
		{
			ETL.deleteByPrimaryKey(ETLIDs.get(0).getStrategyid());
		}catch(Exception e)
		{
			return false;
		}
		
		//删除用户-ETL表中 数据
		try
		{
			userETL.deleteByExample(oneExample);
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
		//验证该用户是否存在 指定数据源
		UserStrategyExample oneExample=new UserStrategyExample();
		oneExample.or().andUseridEqualTo(theUserID);
		oneExample.or().andStrategyidEqualTo(theEtl.getId());
		List<UserStrategy> etlIDs;
		try
		{
			etlIDs=userETL.selectByExample(oneExample);
		}catch(Exception e)
		{
			return false;
		}
		if(etlIDs.size()==0)  //不存在这条ETL规则
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


	
	

}

