package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.AlgorithmParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlgorithmParameterMapper {
    int countByExample(AlgorithmParameterExample example);

    int deleteByExample(AlgorithmParameterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlgorithmParameter record);

    int insertSelective(AlgorithmParameter record);

    List<AlgorithmParameter> selectByExample(AlgorithmParameterExample example);

    AlgorithmParameter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlgorithmParameter record, @Param("example") AlgorithmParameterExample example);

    int updateByExample(@Param("record") AlgorithmParameter record, @Param("example") AlgorithmParameterExample example);

    int updateByPrimaryKeySelective(AlgorithmParameter record);

    int updateByPrimaryKey(AlgorithmParameter record);
}