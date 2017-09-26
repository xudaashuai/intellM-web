package com.cug.intellM.web.service;
import java.util.List;

import com.cug.intellM.web.po.*;



//�û�����ETL����ӿ�

public interface ETLService 
{
	
	
    public boolean insertETL(String loginname, ETL etl);//�û����etl���� ������ָ��etl����id��
	
	public List<ETL> getETL(String loginname);//��ȡ�û�����etl����ʧ�ܻ��޷��� null
	
	public boolean deleteETL(String loginname, int etlID);//ɾ���ƶ�id��ETL����ʧ�ܷ���false
	
	public boolean updateETL(String loginname, ETL theEtl);//�޸�ETL������Ҫ��etl��ָ��id��  ʧ�ܷ���false
	
	public ETL getETLbyid(String loginname, int etlID);//��ȡָ��ETLID����������
	

}
