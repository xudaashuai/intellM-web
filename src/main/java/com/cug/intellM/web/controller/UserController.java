package com.cug.intellM.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cug.intellM.web.po.User;
import com.cug.intellM.web.service.UserService;

/** 
 2017/9/17
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping("/checkLoginName")
	//验证用户账号是否存在
	public void checkLoginName()
	{
		
		String loginname="theLoginame";

		if(userService.checkloginName(loginname)==true)
		{
			System.out.print("已经存在该用户");
		}
		else
		{
			System.out.print("不存在该用户");
		}
		
	}
	

	@RequestMapping("/checkPassword")
	//验证用户账号是否存在
	public void checkPassword()
	{
		
		String loginname="theLoginName";
		String password="thepassword";

		if(userService.checkPassword(loginname,password)==true)
		{
			System.out.print("登陆成功");
		}
		else
		{
			System.out.print("登陆失败");
		}
		
	}
	
	@RequestMapping("/insertUser")
	//注册一般用户
	public void insertUser()
	{
		
		String Name="李华";
		int Sex=1;
		String loginname="007";
		String password="12345";
		String Dept_ID="cug信工学院";

		if(userService.insertUser(Name, Sex, loginname, password, Dept_ID)==true)
		{
			System.out.print("注册成功");
		}
		else
		{
			System.out.print("注册失败");
		}
		
	}
	

	@RequestMapping("/updatepassword")
	//注册一般用户
	public void updatePassword()
	{
		
		
		String loginname="007";
		String password="12345";
	

		if(userService.updatePassword(loginname, password)==true)
		{
			System.out.print("修改密码成功");
		}
		else
		{
			System.out.print("修改密码失败");
		}
		
	}
}

