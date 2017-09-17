package com.cug.intellM.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.User;
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
		User user = null;
		try 
		{
			
				user = userMapper.GetUserByLoginName(loginName);
			
		} catch (Exception e) 
		{
			return false;
		}
		if(user==null)
			return false;
		else
		{
			System.out.println("存在");
			return true;
		}
			
	}
	
	//检查登陆密码是否正确,若已经登陆也返回false
	
	
	public boolean checkPassword(String loginName,String Password)
	{
		System.out.print(Password);
		User user = null;
		try {
			user = userMapper.GetUserByLoginName(loginName);
		} catch (Exception e) 
		{
			return false;
		}
		if(user==null)
		{
			System.out.print("没有该用户！");
			return false;
		}
		if(user.getState()==1)  //已经登陆
		{
			
			System.out.print("已经登陆！");
			return false;
			
			
		}
		{
			if(user.getPassword().equals(Password))
			{
				user.setState(1);
				return true;
				
			}		
			else
				return false;
		
		}
			
	}
	
	//验证成功后，调用此函数获取用户类型 0 普通用户 1 管理员
	
	public int getUser_Type(String loginName)
	{
		User user = null;
		try
		{
			user = userMapper.GetUserByLoginName(loginName);
		} catch (Exception e)
		{
			
		}
	    return user.getUser_Type();
	}
	
	//新增一个普通用户
	
	public boolean insertUser(String Name,int Sex,String LoginName,String password,String Dept_ID)
	{
		
		//先判断用户账号是否已经存在
		if(this.checkloginName(LoginName)==true)
			return false;
		User newuser=new User();
		newuser.setName(Name);
		newuser.setLoginName(LoginName);
		newuser.setPassword(password);
		newuser.setSex(Sex);
		newuser.setDept_ID(Dept_ID);
		newuser.setUser_Type(0);//0普通用户
		newuser.setState(0);//初始化状态为0 未登录
		try 
		{
			userMapper.InsertOneUser(newuser);
		} catch (Exception e) 
		{
			return false;
		} //调用dao层
		return true;
		
		
	}
	//新增一个管理员
	
	public boolean insertAdministrator(String Name,int Sex,String LoginName,String password,String Dept_ID)
	{
		
		//先判断用户账号是否已经存在
		if(this.checkloginName(LoginName)==true)
			return false;
		User newuser=new User();
		newuser.setName(Name);
		newuser.setLoginName(LoginName);
		newuser.setPassword(password);
		newuser.setSex(Sex);
		newuser.setDept_ID(Dept_ID);
		newuser.setUser_Type(1);//1 管理员
		newuser.setState(0);//初始化状态为0 未登录
		try 
		{
			userMapper.InsertOneUser(newuser);
		} catch (Exception e) 
		{
			return false;
		} //调用dao层
		return true;
		
		
	}
	
	//根据账号获取用户基本信息
	public User getUserByLoginName(String loginname)
	{
		User user=null;
		try 
		{
			
			user= userMapper.GetUserByLoginName(loginname);
			
		} catch (Exception e) 
		{
			
			
			return null;
		}
		return user;
	}
	
	//修改昵称
	public boolean updateName(String loginname,String newname)
	{
		
		User user = this.getUserByLoginName(loginname);
		if(user==null)
		{
			return false;
		}
		user.setName(newname);
		try 
		{
			userMapper.UpdateUserdata(loginname, user);
		} catch (Exception e) 
		{
			return false;
		}
		return true;
		
	}
	
	//修改密码
	public boolean updatePassword(String loginname,String password)
	{

		User user = this.getUserByLoginName(loginname);
	    if(user==null)
	    	return false;
		user.setPassword(password);
		try 
		{
			userMapper.UpdateUserdata(loginname, user);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	

}
