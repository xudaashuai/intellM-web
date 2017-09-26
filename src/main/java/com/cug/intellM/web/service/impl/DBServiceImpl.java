package com.cug.intellM.web.service.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.service.DBService;
@Transactional
@Service
public class DBServiceImpl implements DBService
{
	public static final String name = "com.mysql.jdbc.Driver"; 
	
	public Connection getConnection(String url,String Name,String Password)
	{
		try 
		{
			Class.forName(name);
		} catch (ClassNotFoundException e2) 
		{
			System.out.print("加载驱动失败");
			return null;
		}
        Connection conn;
		try 
		{
			conn = DriverManager.getConnection(url,Name, Password);
		} catch (SQLException e2) 
		{
			System.out.print("连接数据库失败！");
			return null;
		} 
		return conn;
	}

	public List<String> getTablesByURL(String url, String Name, String Password) 
	{
		
		
		
		List<String> tables=new ArrayList<String>();
		Connection conn=this.getConnection(url, Name, Password);
		try 
		{  
			   DatabaseMetaData meta = conn.getMetaData();  
			   ResultSet rs = meta.getTables(null, null, null,  
			     new String[] { "TABLE" });  
			   while (rs.next()) 
			   {  
			     System.out.println("表名：" + rs.getString(3));  
			     tables.add(rs.getString(3));
			     
			   }  
			  
	     }catch (Exception e) 
		{
	    	 return null;
		} 
		try 
		{
			conn.close();
		} catch (SQLException e) 
		{
			
		}
		return tables;
	}

	//获取指定表的列名
	public List<String> getCloumns(String url, String Name, String Password, String tableName)
	{
		
		List<String> result=new ArrayList<String>();
		Connection conn = this.getConnection(url,Name,Password);
		String sql = "select * from "+tableName;
		PreparedStatement stmt;
		try 
		{
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			for (int i = 1; i <= data.getColumnCount(); i++) 
			{
		
			
			   String columnName = data.getColumnName(i);
			   result.add(columnName);
			}
		
		} catch (SQLException e) 
		{
		   return null;
		}
		try 
		{
			conn.close();    //关闭数据库连接
		} catch (SQLException e) 
		{
			
		}
		return result;
	}

}
