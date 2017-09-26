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
	private UserMapper userMapper;//用户基本信息
	

	@Autowired
	private UserStrategyMapper userETL;//用户-ETL规则

	
	
	@Autowired
	private StrategyTransformMapper ETLDataTrans;//ETL策略---数据转换规则
	@Autowired
	private TransformRuleMapper transformRule;//检查规则
	
	
	
	
	public int getUserID(String loginName)
	{

	    UserExample itemsExample = new UserExample();
        itemsExample.or().andLoginnameEqualTo(loginName);
        List<User> users=userMapper.selectByExample(itemsExample);
        if(users.size()==0)
        	return -1; 
        return users.get(0).getUserId();    
	}
	
	
	//判断用户是否拥有指定id的ETL策略
	
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
				return false;  //该ETL策略没有该检查策略
			else
				return true;
			
		}

		public boolean insertETLTransRule(String loginname, int etlID, TransformRule transrule) 
		{
			  //若无权限 返回false
			if(this.HasETL(loginname, etlID)==false)
			{		
				return false;
			}
			//在数据转换表TransformRule中插入该转换规则
		
			int ruleID=0;//记录新插入的主键
			try
			{
			      transformRule.insertSelective(transrule);
			      
			}catch(Exception e)
			{
				
				return false;
			}
			ruleID=transrule.getTransRule();//主键
		
			//在ETL策略-转换规则表中插入记录
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
			
			//首先验证该用户是否存在该ETL策略   防止非法访问他人的数据
					//在用户-ETL表中查询
			

			if(this.HasETL(loginname, etlID)==false)
				return null;
			
			//在ETL-转换规则中获取该ETL所有转换规则的主键集合
			
			
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
			//为了防止非法删除，先验证该用户是否具有该ETL策略
					if(this.HasETL(loginname, etlID)==false)
						return false;
					//判断该ETL策略是否具有该转换策略
					if(this.HasTransRule(etlID, transRuleID)==false)
						return false;
					
					//先删除checkRule表中指定 ID的数据
					
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
					//删除ETL-转换规则表中 数据
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
			
			//判断是否有更改权限（即是否拥有该ETL策略）
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
