package com.cug.intellM.web.service;

import java.util.List;

import com.cug.intellM.web.po.*;


public interface UserService 
{

	
	
	/*��½��֤ģ��*/
	
	public boolean checkloginName(String loginName);//��ѯ�˺��Ƿ���� �Ƿ���true
	
	public boolean checkPassword(String loginName, String Password);//��֤��½���� �ɹ�����true
	
	public boolean IsLogin(String loginname);//�ж��˺��Ƿ��Ѿ���½
	
	public boolean setState(String loginname, int thestate);//�����û���½״̬��δ��¼0  �Ѿ���½1��  ����ʧ�ܷ���false
	
	public int getUser_Type(String loginName);//��֤�ɹ��󣬵��ô˺�����ȡ�û����� 0 ��ͨ�û� 1 ����Ա
	
	/*�û�������Ϣ����*/
	
	public User getUserByLoginName(String LoginName);//�����˺Ų�ѯ�û���Ϣ    ���޷���:NULL
	
	public boolean insertUser(String Name, int Sex, String LoginName, String password, String Dept_ID);//������ͨ�û� dept_id ��������
	
	public boolean insertAdministrator(String Name, int Sex, String LoginName, String password, String Dept_ID);//��������Ա
	
	public boolean updateUserData(String loginname, User user);//�޸Ĳ�����Ϣ���޸�User�ж�Ӧ��ΪNull������
	
	public boolean updateName(String loginname, String newname);//�޸��ǳ�  ʧ�ܷ���false
	
	public boolean updatePassword(String loginname, String password);//�޸�����    ʧ�ܷ���false
	

	
	
	
	

	
}
