package com.cug.intellM.web.service;

import java.util.List;

public interface DBService 
{

	public List<String> getTablesByURL(String url, String Name, String Password);//��ȡ����URL���ݿ����б�   ʧ�ܷ���null
	public Object testDatabase(String url, String Name, String Password);//��ȡ����URL���ݿ����б�   ʧ�ܷ���null
	public List<String> getCloumns(String url, String Name, String Password, String tableName);//��ȡָ�����������  ʧ�ܷ���null

}
