package com.cug.intellM.web.service;

import java.util.List;

import com.cug.intellM.web.po.*;


public interface UserService 
{

	
	
	/*登陆验证模块*/
	
	public boolean checkloginName(String loginName);//查询账号是否存在 是返回true
	
	public boolean checkPassword(String loginName,String Password);//验证登陆密码 成功返回true
	
	public boolean IsLogin(String loginname);//判断账号是否已经登陆
	
	public boolean setState(String loginname,int thestate);//设置用户登陆状态（未登录0  已经登陆1）  设置失败返回false
	
	public int getUser_Type(String loginName);//验证成功后，调用此函数获取用户类型 0 普通用户 1 管理员
	
	/*用户基本信息管理*/
	
	public User getUserByLoginName(String LoginName);//根据账号查询用户信息    若无返回:NULL
	
	public boolean insertUser(String Name,int Sex,String LoginName,String password,String Dept_ID);//新增普通用户 dept_id 所属部门
	
	public boolean insertAdministrator(String Name,int Sex,String LoginName,String password,String Dept_ID);//新增管理员
	
	public boolean updateUserData(String loginname,User user);//修改部分信息，修改User中对应不为Null的数据
	
	public boolean updateName(String loginname,String newname);//修改昵称  失败返回false
	
	public boolean updatePassword(String loginname,String password);//修改密码    失败返回false
	
	/*用户数据源管理*/
	
	
	
	public boolean insertETLSource(String loginname,ETLDataSource etlSource);//用户添加数据源
	
	public List<ETLDataSource> getETLDataSource(String loginname);//获取用户所有数据源  失败或无返回 null
	
	public boolean deleteETLDataSource(String loginname,int SourceID);//删除指定id的数据源 失败返回false
	
	public boolean updateETLDataSource(String loginname,ETLDataSource thesource);//修改数据源(需要在source中指定sourceID)  失败返回false
	
	/*用户ETL规则管理*/
	
	public boolean insertETL(String loginname,ETL etl);//用户添加etl规则 （无需制定etl主键id）
	
	public List<ETL> getETL(String loginname);//获取用户所有etl规则，失败或无返回 null
	
	public boolean deleteETL(String loginname,int etlID);//删除制定id的ETL规则，失败返回false
	
	public boolean updateETL(String loginname,ETL theEtl);//修改ETL规则（需要在etl中指定id）  失败返回false
	

	
}
