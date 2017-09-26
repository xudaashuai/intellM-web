package com.cug.intellM.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.*;
import com.cug.intellM.web.po.*;

import com.cug.intellM.web.service.ETLSourceService;;



@Transactional
@Service
public class ETLSourceServiceImpl implements ETLSourceService
{

	
	
	
	//Service层 利用dao层提供的基本功能     组织成更为丰富的服务
		@Autowired
		private UserMapper userMapper;//用户基本信息
		
		@Autowired
		private UserSourceMapper userSource;//用户-数据源
		@Autowired
		private ETLDataSourceMapper ETLDataSource;//数据源
		
	
		
		
		
		
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
		

	 //指定用户  新增ETL数据源   失败返回false   （不用指定ETLSource主健 --自增主键）
		public boolean insertETLSource(String loginname, ETLDataSource etlSource) 
		{
			
			//若账号不存在 返回false
			if(this.checkloginName(loginname)==false)
			{		
				return false;
			}
			//在数据源表中插入该数据源
		
			int SourceID=0;//记录新插入的
			try
			{
			      ETLDataSource.insertSelective(etlSource);
			      
			}catch(Exception e)
			{
				
				
				return false;
			}
			SourceID=etlSource.getId();//主键
		
			//在用户-数据源表中插入记录
			UserSourceKey newUserSource=new UserSourceKey();
			int theUserID=getUserID(loginname);
			if(theUserID==-1)
			{
				
			
				return false;
			}
			newUserSource.setUserid(theUserID);
			newUserSource.setSourceid(SourceID);
			try
			{
			       userSource.insert(newUserSource);
			}catch(Exception e)
			{
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
			List<UserSourceKey> sourceIDs;
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
			
			
			//验证用户是否存在 该id数据源(防止删除其它用户数据源)
			UserSourceExample oneExample=new UserSourceExample();
			oneExample.or().andUseridEqualTo(theUserID);
			oneExample.or().andSourceidEqualTo(SourceID);
			List<UserSourceKey> sourceIDs;
			try
			{
				sourceIDs=userSource.selectByExample(oneExample);
				
			}catch(Exception e)
			{
				System.out.print("出现异常-_-");
				return false;
			}
			System.out.print(sourceIDs.size());
			if(sourceIDs.size()==0)
				return false;
			//先删除 数据源表中指定 SourceID的数据
			
			try
			{
				ETLDataSource.deleteByPrimaryKey(SourceID);
			}catch(Exception e)
			{
				return false;
			}
			UserSourceKey thekey=new UserSourceKey();
			thekey.setSourceid(SourceID);
			thekey.setUserid(theUserID);
			//删除用户-数据源表中 数据
			try
			{
				userSource.deleteByPrimaryKey(thekey);
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
			List<UserSourceKey> sourceIDs;
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

		public ETLDataSource getETLDataSourceByid(int SourceID) 
		{
			
			
			try
			{
				return ETLDataSource.selectByPrimaryKey(SourceID);
			}catch(Exception e)
			{
				return null;
			}
		
			
		}
		

}
