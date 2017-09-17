package com.cug.intellM.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.User;
import com.cug.intellM.web.po.UserExample;
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
	private UserMapper userMapper;
	
	
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
	        	return true;      //账号已被注册
		
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
	
	

}

