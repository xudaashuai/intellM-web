package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.ModelAlgorithmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelAlgorithmMapper {
    int countByExample(ModelAlgorithmExample example);

    int deleteByExample(ModelAlgorithmExample example);

    int deleteByPrimaryKey(String modelId);

    int insert(ModelAlgorithm record);

    int insertSelective(ModelAlgorithm record);

    List<ModelAlgorithm> selectByExample(ModelAlgorithmExample example);

    ModelAlgorithm selectByPrimaryKey(String modelId);

    int updateByExampleSelective(@Param("record") ModelAlgorithm record, @Param("example") ModelAlgorithmExample example);

    int updateByExample(@Param("record") ModelAlgorithm record, @Param("example") ModelAlgorithmExample example);

    int updateByPrimaryKeySelective(ModelAlgorithm record);

    int updateByPrimaryKey(ModelAlgorithm record);
}