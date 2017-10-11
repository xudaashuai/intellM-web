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
			System.out.print("��������ʧ��");
			return null;
		}
        Connection conn;
		try 
		{
			conn = DriverManager.getConnection(url,Name, Password);
		} catch (SQLException e2) 
		{
			System.out.print("�������ݿ�ʧ�ܣ�");
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
			     System.out.println("������" + rs.getString(3));  
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

	public Object testDatabase(String url, String Name, String Password) {
		try
		{
			Class.forName(name);
		} catch (ClassNotFoundException e2)
		{
			System.out.print("��������ʧ��");
			return e2;
		}
		Connection conn;
		try
		{
			conn = DriverManager.getConnection(url,Name, Password);
		} catch (SQLException e2)
		{
			System.out.print("�������ݿ�ʧ�ܣ�");
			return e2;
		}
		return null;
	}

	//��ȡָ���������
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
			conn.close();    //�ر����ݿ�����
		} catch (SQLException e) 
		{
			
		}
		return result;
	}

}
