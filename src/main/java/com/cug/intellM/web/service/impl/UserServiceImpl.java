package com.cug.intellM.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.*;
import com.cug.intellM.web.po.*;

import com.cug.intellM.web.service.UserService;

/** 
 * 
 */

@Transactional
@Service
public class UserServiceImpl implements UserService
{

	
	
	//Service�� ����dao���ṩ�Ļ�������     ��֯�ɸ�Ϊ�ḻ�ķ���
	@Autowired
	private UserMapper userMapper;//�û�������Ϣ
	
	@Autowired
	private UserSourceMapper userSource;//�û�-����Դ
	@Autowired
	private ETLDataSourceMapper ETLDataSource;//����Դ
	
	@Autowired
	private UserStrategyMapper userETL;//�û�-ETL����
	@Autowired
	private ETLMapper ETL;//ETL����
	

	
	
	@Autowired
	private StrategyTransformMapper ETLDataTrans;//ETL����---����ת������
	@Autowired
	private TransformRuleMapper transformRule;//������
	
	
	//����˺��Ƿ��Ѿ�����

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
	
	//����û��˺� �����Ƿ���ȷ
	
	
	public boolean checkPassword(String loginName,String Password)
	{
		
		    UserExample itemsExample = new UserExample();
	        itemsExample.or().andLoginnameEqualTo(loginName);
	        itemsExample.or().andPasswordEqualTo(Password);
	        List<User> users;
	        try
	        {
	            users=userMapper.selectByExample(itemsExample);
	            
	        }catch(Exception e)
	        {
	        	return false;  //�����쳣����false
	        }
	        
	        if(users.size()==0)
	        	return false;    
	        else
	        	return true;      //��֤�ɹ�
		
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
	
	//����û��Ƿ��Ѿ���½
	public boolean IsLogin(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users;
        try
        {
           users=userMapper.selectByExample(itemsExample);
           
        }catch(Exception e)
        {
        	return true;
        }
        if(users.size()==0)
        	return true; 
        {
        	if(users.get(0).getState()==0)
        		return false;
        	else
        		return true;   //�Ѿ���½
        	
        }
       
		
	}
	
	//�����û���½״̬��δ��¼0  �Ѿ���½1��  ����ʧ�ܷ���false
	public boolean setState(String loginname,int thestate)
	{
		  int userID=this.getUserID(loginname);
		  if(userID==-1)
			  return false;
		  User user=new User();
		  user.setState(thestate);
		  try
		  {
			  userMapper.updateByPrimaryKeySelective(user);
		  }catch(Exception e)
		  {
			  return false;
		  }
		  return true;
		
	}
	//��֤�ɹ��󣬵��ô˺�����ȡ�û����� 0 ��ͨ�û� 1 ����Ա
	
	public int getUser_Type(String loginName)
	{
		    UserExample itemsExample = new UserExample();
	        itemsExample.or().andLoginnameEqualTo(loginName);
	        List<User> users=userMapper.selectByExample(itemsExample);
	        if(users.size()==0)
	        	return 0; 
	        return users.get(0).getUserType();    
	}
	
	
	
	
	/*
	 * 
	 * 
	�û�������Ϣ����
	 */
	
	
	//�����˺Ż�ȡ�û�������Ϣ  ��User����
	
	public User getUserByLoginName(String loginname)
	{
		
		    UserExample itemsExample = new UserExample();
		    itemsExample.createCriteria().andLoginnameEqualTo(loginname);
		    List<User> users;
	        try
	        {
	            users=userMapper.selectByExample(itemsExample);
	        }catch(Exception e)
	        {
	        	return null;
	        }
	        if(users.size()==0)
	        	return null; 
	        return users.get(0);    
		
	}
		
		
	
	//����һ����ͨ�û�   ʧ�ܷ���false
	
	public boolean insertUser(String Name,int Sex,String LoginName,String password,String Dept_ID)
	{
		//���Ѿ����� ����false
				if(this.checkloginName(LoginName)==true)
					return false;
				User newuser=new User();
				newuser.setName(Name);
				newuser.setSex(Sex);
				newuser.setLoginname(LoginName);
				newuser.setPassword(password);
				newuser.setDeptId(Dept_ID);
				newuser.setUserType(0);  //0��ͨ�û�
				int result=0;
				try
				{
				       result=userMapper.insertSelective(newuser);
				}catch(Exception e)
				{
					return false;
				}
				System.out.println(result);
				return true;
		
		
		
	}
	//����һ������Ա    ʧ�ܷ���false
	
	public boolean insertAdministrator(String Name,int Sex,String LoginName,String password,String Dept_ID)
	{
		
		      //���Ѿ����� ����false
				if(this.checkloginName(LoginName)==true)
					return false;
				User newuser=new User();
				newuser.setName(Name);
				newuser.setSex(Sex);
				newuser.setLoginname(LoginName);
				newuser.setPassword(password);
				newuser.setDeptId(Dept_ID);
				newuser.setUserType(1);  //0��ͨ�û�
				int result=0;
				try
				{
				       result=userMapper.insertSelective(newuser);
				}catch(Exception e)
				{
					return false;
				}
				System.out.println(result);
				return true;
		
	
	}
	
	
	//�޸�ָ���˺ŵ��ǳ�   ʧ�ܷ���false
	public boolean updateName(String loginname,String newname)
	{
		//���˺Ų����� ����false
		if(this.checkloginName(loginname)==false)
			return false;
		
		//���ø�������
		User user=new User();
		user.setName(newname);
		UserExample itemsExample = new UserExample();
	    itemsExample.or().andLoginnameEqualTo(loginname);
	    try
	    {
	    	userMapper.updateByExampleSelective(user, itemsExample);   //ֻ����Name�ֶ�
	    }catch(Exception e)
	    {
	    	return false;
	    }
		return true;
		
	}
	
	//�޸�����  ʧ�ܷ���false
	public boolean updatePassword(String loginname,String password)
	{

		       //���˺Ų����� ����false
				if(this.checkloginName(loginname)==false)
					return false;
				
				//���ø�������
				User user=new User();
				user.setPassword(password);
				UserExample itemsExample = new UserExample();
			    itemsExample.or().andLoginnameEqualTo(loginname);
			    try
			    {
			    	userMapper.updateByExampleSelective(user, itemsExample);   //ֻ����Password�ֶ�
			    }catch(Exception e)
			    {
			    	return false;
			    }
				return true;
	}
	//�޸��û�������Ϣ
	public boolean updateUserData(String loginname,User user)
	{

		       //���˺Ų����� ����false
				if(this.checkloginName(loginname)==false)
					return false;
				
				//���ø�������
				
				UserExample itemsExample = new UserExample();
			    itemsExample.or().andLoginnameEqualTo(loginname);
			    try
			    {
			    	userMapper.updateByExampleSelective(user, itemsExample);   //ֻ����User��ΪNull�ֶ�
			    }catch(Exception e)
			    {
			    	return false;
			    }
				return true;
	}
	
	
	
	
	
	

	
	

}
