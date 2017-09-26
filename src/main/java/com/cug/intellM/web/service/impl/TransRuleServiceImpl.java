package com.cug.intellM.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.*;
import com.cug.intellM.web.po.*;

import com.cug.intellM.web.service.TransRuleService;

@Transactional
@Service
public class TransRuleServiceImpl implements TransRuleService
{
	@Autowired
	private UserMapper userMapper;//�û�������Ϣ
	

	@Autowired
	private UserStrategyMapper userETL;//�û�-ETL����

	
	
	@Autowired
	private StrategyTransformMapper ETLDataTrans;//ETL����---����ת������
	@Autowired
	private TransformRuleMapper transformRule;//������
	
	
	
	
	public int getUserID(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users=userMapper.selectByExample(itemsExample);
        if(users.size()==0)
        	return -1; 
        return users.get(0).getUserId();    
	}
	
	
	//�ж��û��Ƿ�ӵ��ָ��id��ETL����
	
		public boolean HasETL(String loginname,int etlID)
		{
			
			int theUserID=this.getUserID(loginname);
			if(theUserID==-1)
				return false;
			UserStrategyExample oneExample=new UserStrategyExample();
			oneExample.or().andUseridEqualTo(theUserID);
			oneExample.or().andStrategyidEqualTo(etlID);
			List<UserStrategyKey> ETLIDs;
			try
			{
				ETLIDs=userETL.selectByExample(oneExample);
				
			}catch(Exception e)
			{
				return false;
			}
			if(ETLIDs.size()==0)
				return false;
			else
				return true;
		}


		
		
		public boolean HasTransRule(int etlID,int checkruleID)
		{
			StrategyTransformExample theExample=new StrategyTransformExample();
			theExample.or().andStrategyidEqualTo(etlID);
			theExample.or().andRuleidEqualTo(checkruleID);
			List<StrategyTransformKey> transruleIDs;
			try
			{
				transruleIDs=ETLDataTrans.selectByExample(theExample);
			}catch(Exception e)
			{
			
				return false;
			}
			if(transruleIDs.size()==0)
				return false;  //��ETL����û�иü�����
			else
				return true;
			
		}

		public boolean insertETLTransRule(String loginname, int etlID, TransformRule transrule) 
		{
			  //����Ȩ�� ����false
			if(this.HasETL(loginname, etlID)==false)
			{		
				return false;
			}
			//������ת����TransformRule�в����ת������
		
			int ruleID=0;//��¼�²��������
			try
			{
			      transformRule.insertSelective(transrule);
			      
			}catch(Exception e)
			{
				
				return false;
			}
			ruleID=transrule.getTransRule();//����
		
			//��ETL����-ת��������в����¼
			StrategyTransformKey newETLTransrule=new StrategyTransformKey();
		
			newETLTransrule.setStrategyid(etlID);
			newETLTransrule.setRuleid(ruleID);;
			try
			{
			       ETLDataTrans.insert(newETLTransrule);
			}catch(Exception e)
			{
				return false;
			}
			return true;
				
		}

		public List<TransformRule> getETLTransRule(String loginname, int etlID) 
		{
			
			//������֤���û��Ƿ���ڸ�ETL����   ��ֹ�Ƿ��������˵�����
					//���û�-ETL���в�ѯ
			

			if(this.HasETL(loginname, etlID)==false)
				return null;
			
			//��ETL-ת�������л�ȡ��ETL����ת���������������
			
			
			StrategyTransformExample theExample=new StrategyTransformExample();
			theExample.or().andStrategyidEqualTo(etlID);
			List<StrategyTransformKey> transruleIDs;
			try
			{
				transruleIDs=ETLDataTrans.selectByExample(theExample);
			}catch(Exception e)
			{
			
				return null;
			}
			List<TransformRule> rules=new ArrayList<TransformRule>();
			for(int i=0;i<transruleIDs.size();i++)
			{
				rules.add(transformRule.selectByPrimaryKey( transruleIDs.get(i).getRuleid()));
			}
			return  rules;		
					
					
			
		}

		public boolean deleteETLTransRule(String loginname, int etlID, int transRuleID) 
		{
			//Ϊ�˷�ֹ�Ƿ�ɾ��������֤���û��Ƿ���и�ETL����
					if(this.HasETL(loginname, etlID)==false)
						return false;
					//�жϸ�ETL�����Ƿ���и�ת������
					if(this.HasTransRule(etlID, transRuleID)==false)
						return false;
					
					//��ɾ��checkRule����ָ�� ID������
					
					try
					{
						transformRule.deleteByPrimaryKey(transRuleID);
						
					}catch(Exception e)
					{
						return false;
					}
					StrategyTransformKey thekey=new StrategyTransformKey();
					thekey.setStrategyid(etlID);
					thekey.setRuleid(transRuleID);
					//ɾ��ETL-ת��������� ����
					try
					{
						ETLDataTrans.deleteByPrimaryKey(thekey);
					}catch(Exception e)
					{
						return false;
					}
					return true;
					
		}

		public boolean updateETLTransRule(String loginname, int etlID, TransformRule transrule) 
		{
			
			//�ж��Ƿ��и���Ȩ�ޣ����Ƿ�ӵ�и�ETL���ԣ�
					if(this.HasETL(loginname, etlID)==false)
						return false;
					if(this.HasTransRule(etlID, transrule.getTransRule())==false)
						return false;
					try
					{
						transformRule.updateByPrimaryKeySelective(transrule);
					}catch(Exception e)
					{
						return false;
					}
					return true;
			
		}


		public TransformRule getETLTransRuleByID(int transRuleID) 
		{
			try
			{
				return transformRule.selectByPrimaryKey(transRuleID);
			}catch(Exception e)
			{
				return null;
			}
			
		}


	
	
	
	


}
