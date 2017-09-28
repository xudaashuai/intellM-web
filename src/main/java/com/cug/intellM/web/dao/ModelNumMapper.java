package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.ModelNum;
import com.cug.intellM.web.po.ModelNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelNumMapper {
    int countByExample(ModelNumExample example);

    int deleteByExample(ModelNumExample example);

    int deleteByPrimaryKey(Integer model);

    int insert(ModelNum record);

    int insertSelective(ModelNum record);

    List<ModelNum> selectByExample(ModelNumExample example);

    ModelNum selectByPrimaryKey(Integer model);

    int updateByExampleSelective(@Param("record") ModelNum record, @Param("example") ModelNumExample example);

    int updateByExample(@Param("record") ModelNum record, @Param("example") ModelNumExample example);

    int updateByPrimaryKeySelective(ModelNum record);

    int updateByPrimaryKey(ModelNum record);
}