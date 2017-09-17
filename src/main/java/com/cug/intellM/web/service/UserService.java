package com.cug.intellM.web.service;

import com.cug.intellM.web.po.User;


public interface UserService 
{

	
	// 账号loginname 唯一
	public boolean checkloginName(String loginName);//查询账号是否存在 是返回true
	public boolean checkPassword(String loginName,String Password);//验证登陆密码 成功返回true，(已经登陆也返回false)  登陆成功将设置状态为1(已经登陆)
	public int getUser_Type(String loginName);//验证成功后，调用此函数获取用户类型 0 普通用户 1 管理员
	public User getUserByLoginName(String LoginName);//根据登陆账号查询用户信息
	public boolean insertUser(String Name,int Sex,String LoginName,String password,String Dept_ID);//新增普通用户 dept_id 所属部门
	public boolean insertAdministrator(String Name,int Sex,String LoginName,String password,String Dept_ID);//新增管理员
	public boolean updateName(String loginname,String newname);//修改昵称
	public boolean updatePassword(String loginname,String password);//修改密码
}

