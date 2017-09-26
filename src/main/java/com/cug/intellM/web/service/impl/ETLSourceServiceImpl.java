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

	
	
	
	//Service�� ����dao���ṩ�Ļ�������     ��֯�ɸ�Ϊ�ḻ�ķ���
		@Autowired
		private UserMapper userMapper;//�û�������Ϣ
		
		@Autowired
		private UserSourceMapper userSource;//�û�-����Դ
		@Autowired
		private ETLDataSourceMapper ETLDataSource;//����Դ
		
	
		
		
		
		
		public boolean checkloginName(String loginName)
		{
			
			//�����ѯ����
			    UserExample itemsExample = new UserExample();
		        itemsExample.or().andLoginnameEqualTo(loginName);
		        List<User> users;
		        try
		        {
		        	users=userMapper.selectByExample(itemsExample);
		        }catch(Exception e)
		        {
		        	return true;    //�쳣����
		        }
		        if(users.size()==0)
		        	return false;    //�˺�δ��ע��
		        else
		        	return true;      //�˺��ѱ�ע��
		 
		}
		
		//�����˺� ��ȡID  ʧ�ܷ���-1
		

		public int getUserID(String loginName)
		{

		    UserExample itemsExample = new UserExample();
	        itemsExample.or().andLoginnameEqualTo(loginName);
	        List<User> users=userMapper.selectByExample(itemsExample);
	        if(users.size()==0)
	        	return -1; 
	        return users.get(0).getUserId();    
		}
		

	 //ָ���û�  ����ETL����Դ   ʧ�ܷ���false   ������ָ��ETLSource���� --����������
		public boolean insertETLSource(String loginname, ETLDataSource etlSource) 
		{
			
			//���˺Ų����� ����false
			if(this.checkloginName(loginname)==false)
			{		
				return false;
			}
			//������Դ���в��������Դ
		
			int SourceID=0;//��¼�²����
			try
			{
			      ETLDataSource.insertSelective(etlSource);
			      
			}catch(Exception e)
			{
				
				
				return false;
			}
			SourceID=etlSource.getId();//����
		
			//���û�-����Դ���в����¼
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
		
		//����ָ���û���������Դ  List<ETLSource>
		public List<ETLDataSource> getETLDataSource(String loginname)
		{
			int theUserID=getUserID(loginname);
			if(theUserID==-1)
				return null;
			//�� �û�-����Դ���в�������û�����Դid
			UserSourceExample oneExample=new UserSourceExample();
			oneExample.or().andUseridEqualTo(theUserID);
			List<UserSourceKey> sourceIDs;
			try
			{
				sourceIDs=userSource.selectByExample(oneExample);
			}catch(Exception e)
			{
				System.out.print("�����쳣");
				return null;
			}
			List<ETLDataSource> Sources=new ArrayList<ETLDataSource>();
			for(int i=0;i<sourceIDs.size();i++)
			{
				Sources.add(ETLDataSource.selectByPrimaryKey( sourceIDs.get(i).getSourceid()));
			}
			return  Sources;
				
		}
		
		//�û�ɾ��ָ��id������Դ
		public boolean deleteETLDataSource(String loginname,int SourceID)
		{

			int theUserID=getUserID(loginname);
			if(theUserID==-1)
				return false;
			
			
			//��֤�û��Ƿ���� ��id����Դ(��ֹɾ�������û�����Դ)
			UserSourceExample oneExample=new UserSourceExample();
			oneExample.or().andUseridEqualTo(theUserID);
			oneExample.or().andSourceidEqualTo(SourceID);
			List<UserSourceKey> sourceIDs;
			try
			{
				sourceIDs=userSource.selectByExample(oneExample);
				
			}catch(Exception e)
			{
				System.out.print("�����쳣-_-");
				return false;
			}
			System.out.print(sourceIDs.size());
			if(sourceIDs.size()==0)
				return false;
			//��ɾ�� ����Դ����ָ�� SourceID������
			
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
			//ɾ���û�-����Դ���� ����
			try
			{
				userSource.deleteByPrimaryKey(thekey);
			}catch(Exception e)
			{
				return false;
			}
			return true;
				
		}
		
		//�û��޸�ָ������Դ  ָ���޸ĺ��ETLSource
		public boolean updateETLDataSource(String loginname,ETLDataSource thesource)
		{
			int theUserID=getUserID(loginname);
			if(theUserID==-1)
				return false;
			//��֤���û��Ƿ���� ָ������Դ
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
			
			//�޸�ָ��id������Դ	
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
