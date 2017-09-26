package com.cug.intellM.web.service;

import java.util.List;

import com.cug.intellM.web.po.*;

//�û�����ETL����Դ ����ӿ� 

public interface ETLSourceService 
{
	
	
/*�û�����Դ����*/
	
	
	
	public boolean insertETLSource(String loginname, ETLDataSource etlSource);//�û��������Դ
	
	public List<ETLDataSource> getETLDataSource(String loginname);//��ȡ�û���������Դ  ʧ�ܻ��޷��� null
	
	public boolean deleteETLDataSource(String loginname, int SourceID);//ɾ��ָ��id������Դ ʧ�ܷ���false
	
	public boolean updateETLDataSource(String loginname, ETLDataSource thesource);//�޸�����Դ(��Ҫ��source��ָ��sourceID)  ʧ�ܷ���false
	
	public ETLDataSource getETLDataSourceByid(int SourceID);//��ȡָ��id������Դ
	

}
