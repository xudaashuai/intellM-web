package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.CheckType;
import com.cug.intellM.web.po.CheckTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckTypeMapper {
    int countByExample(CheckTypeExample example);

    int deleteByExample(CheckTypeExample example);

    int deleteByPrimaryKey(Integer value);

    int insert(CheckType record);

    int insertSelective(CheckType record);

    List<CheckType> selectByExample(CheckTypeExample example);

    CheckType selectByPrimaryKey(Integer value);

    int updateByExampleSelective(@Param("record") CheckType record, @Param("example") CheckTypeExample example);

    int updateByExample(@Param("record") CheckType record, @Param("example") CheckTypeExample example);

    int updateByPrimaryKeySelective(CheckType record);

    int updateByPrimaryKey(CheckType record);
}