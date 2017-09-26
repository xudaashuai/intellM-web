package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.TransformType;
import com.cug.intellM.web.po.TransformTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransformTypeMapper {
    int countByExample(TransformTypeExample example);

    int deleteByExample(TransformTypeExample example);

    int deleteByPrimaryKey(Integer value);

    int insert(TransformType record);

    int insertSelective(TransformType record);

    List<TransformType> selectByExample(TransformTypeExample example);

    TransformType selectByPrimaryKey(Integer value);

    int updateByExampleSelective(@Param("record") TransformType record, @Param("example") TransformTypeExample example);

    int updateByExample(@Param("record") TransformType record, @Param("example") TransformTypeExample example);

    int updateByPrimaryKeySelective(TransformType record);

    int updateByPrimaryKey(TransformType record);
}