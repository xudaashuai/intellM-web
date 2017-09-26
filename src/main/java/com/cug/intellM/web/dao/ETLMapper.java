package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.ETL;
import com.cug.intellM.web.po.ETLExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ETLMapper {
    int countByExample(ETLExample example);

    int deleteByExample(ETLExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ETL record);

    int insertSelective(ETL record);

    List<ETL> selectByExample(ETLExample example);

    ETL selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ETL record, @Param("example") ETLExample example);

    int updateByExample(@Param("record") ETL record, @Param("example") ETLExample example);

    int updateByPrimaryKeySelective(ETL record);

    int updateByPrimaryKey(ETL record);
}