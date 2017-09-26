package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.DataAccess;
import com.cug.intellM.web.po.DataAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataAccessMapper {
    int countByExample(DataAccessExample example);

    int deleteByExample(DataAccessExample example);

    int deleteByPrimaryKey(Integer type);

    int insert(DataAccess record);

    int insertSelective(DataAccess record);

    List<DataAccess> selectByExample(DataAccessExample example);

    DataAccess selectByPrimaryKey(Integer type);

    int updateByExampleSelective(@Param("record") DataAccess record, @Param("example") DataAccessExample example);

    int updateByExample(@Param("record") DataAccess record, @Param("example") DataAccessExample example);

    int updateByPrimaryKeySelective(DataAccess record);

    int updateByPrimaryKey(DataAccess record);
}