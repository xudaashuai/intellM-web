package com.cug.intellM.web.service;

import java.util.List;

import com.cug.intellM.web.po.ModelAlgorithm;

public interface ModelService 
{
	public List<ModelAlgorithm> getModelAlgorithms();//��ȡ��ǰ����ģ���㷨
	public String insertModelAlgorithm(int classifcation, ModelAlgorithm onemodel);//����ָ�������㷨ģ�ͣ������²����Model_ID,  ʧ�ܷ���null
	public int insertModelAlgorithm(ModelAlgorithm onemodel);
	public boolean deleteModelAlgorithm(String Model_ID);
	public boolean updateModelAlgorithm(ModelAlgorithm newModel);//��ָ��newModel��Model_ID
	ModelAlgorithm getByModelID(String Model_ID);//����ָ��model_ID���㷨ģ��
	// 添加模型
	public boolean addModel(int userId,String model,String para);
	// 删除模型
	public boolean removeModel(int modelId);
	// 修改模型
	public boolean updateModel(int userId,int modelId,String para);
}
