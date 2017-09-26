package com.cug.intellM.web.service;
import java.util.List;

import com.cug.intellM.web.po.*;
//�û�ΪETL��������ת������ӿ�

public interface TransRuleService 
{
	
	/*ETL-ת���������*/
	public boolean insertETLTransRule(String loginname, int etlID, TransformRule transrule);//Ϊһ��ETL��������ת������
	
	public List<TransformRule> getETLTransRule(String loginname, int etlID);//��ȡָ��ID��ETL���Ե�����ת������
	
	public boolean deleteETLTransRule(String loginname, int etlID, int transRuleID);//ɾ��ָ��ETL�����µ�ָ��ת������
	
	public boolean updateETLTransRule(String loginname, int etlID, TransformRule transrule);//�޸�һ��ת��������ָ�������ID��
	
	public TransformRule getETLTransRuleByID(int transRuleID);//��ȡָ��ID��ETLת������
	
	

}
