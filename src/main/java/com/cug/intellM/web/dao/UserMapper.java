package com.cug.intellM.web.dao;

import java.sql.SQLException;
import java.util.List;
import com.cug.intellM.web.po.User;

/** 
 平台用户数据访问操作接口
 
 */
public interface UserMapper 
{

	
	//dao层  提供user表格的增删查改
	
	void InsertOneUser(User user) throws Exception;   //增加用户信息
	void DeleteOneUser(String loginname) throws Exception;  //删除用户信息（根据账号）
	User GetUserByLoginName(String loginname) throws Exception; //获取用户信息 (根据账号)
	void UpdateUserdata(String loginname,User user) throws Exception; //更新指定账号的用户信息

	
	
}
