package com.cug.intellM.web.service;

import java.util.List;

import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.ModelAlgorithm;

//�㷨����ӿ�

public interface AlgorithmService 
{


	public List<ModelAlgorithm> getModelAlgorithms();//��ȡ��ǰ����ģ���㷨
	public AlgorithmParameter getAlgorithmsParameter(String id);//��ȡ��ǰ����ģ���㷨
	public AlgorithmParameter getSystemAlgorithmsParameter(String id);//��ȡ��ǰ����ģ���㷨
	public AlgorithmParameter getAlgorithmsParameterById(int id);//��ȡ��ǰ����ģ���㷨

	public boolean insertAlgorithmParameter(String username,AlgorithmParameter theParameter);//�û�����һ��ģ���㷨����������ָ��User_ID,id��ʧ�ܷ���false

	public boolean insertAlgorithmParameter2(int User_ID,AlgorithmParameter theParameter);//����User_ID

	public List<AlgorithmParameter> getAlgorithmParameter(String username);//��ȡ�û������㷨��������,�޻�ʧ�ܷ���null

	public List<AlgorithmParameter> getAlgorithmParameter2(int User_ID);//����User_ID

	public boolean deleteAlgorithmParameter(String username,int theParameterID);//�û�ɾ��ָ��ID���㷨����

	public boolean deleteAlgorithmParameter2(int User_ID,int theParameterID);//����User_ID

	public boolean updateAlgorithmParameter(AlgorithmParameter theParameter);//�����㷨����(����theParameterָ��User_ID,ID)






}
