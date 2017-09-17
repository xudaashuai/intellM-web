package com.cug.intellM.web.service;

import com.cug.intellM.web.po.User;


public interface UserService 
{

	
	// 账号loginname 唯一
	public boolean checkloginName(String loginName);//查询账号是否存在 是返回true
	
	public boolean checkPassword(String loginName,String Password);//验证登陆密码 成功返回true
	
	public boolean IsLogin(String loginname);//判断账号是否已经登陆
	
	public int getUser_Type(String loginName);//验证成功后，调用此函数获取用户类型 0 普通用户 1 管理员
	
	public User getUserByLoginName(String LoginName);//根据账号查询用户信息    若无返回:NULL
	
	public boolean insertUser(String Name,int Sex,String LoginName,String password,String Dept_ID);//新增普通用户 dept_id 所属部门
	
	public boolean insertAdministrator(String Name,int Sex,String LoginName,String password,String Dept_ID);//新增管理员
	
	public boolean updateUserData(String loginname,User user);//修改部分信息，修改User中对应不为Null的数据
	
	public boolean updateName(String loginname,String newname);//修改昵称  失败返回false
	
	public boolean updatePassword(String loginname,String password);//修改密码    失败返回false
	
}

