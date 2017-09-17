package com.cug.intellM.web.po;

//平台用户 javabean类  提供get  set方法

public class User {

	private int User_ID;
	private String Name;
	private int Sex;
	private String LoginName;//由登陆账号唯一确定用户
	private String Password;
	private int User_Type;
	private String Dept_ID;
	private int State;
	public User()
	{
		
	}
	
	//get  set方法
	public int getUser_ID()
	{
		return User_ID;
	}
	public void setUser_ID(int _user_ID)
	{
		User_ID=_user_ID;
	}
	
	public String getName()
	{
		return Name;
	}
	public void setName(String _name)
	{
		Name=_name;
	}
	
	public int getSex()
	{
		return Sex;
	}
	public void setSex(int _sex)
	{
		Sex=_sex;
	}
	
	public String getLoginName()
	{
		return LoginName;
	}
	public void setLoginName(String _loginname)
	{
		LoginName=_loginname;
	}
	
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String _password)
	{
		Password=_password;
	}
	
	public int getUser_Type()
	{
		return User_Type;
	}
	public void setUser_Type(int _user_type)
	{
		User_Type=_user_type;
	}
	
	public String getDept_ID()
	{
		return Dept_ID;
	}
	public void setDept_ID(String _dept_id)
	{
		Dept_ID=_dept_id;
	}
	
	public int getState()
	{
		return State;
	}
	public void setState(int _state)
	{
		State=_state;
	}



	
	@Override
	public String toString() 
	{
		
		return Name;
	}
	
}
