package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.ETLDataSource;
import com.cug.intellM.web.po.ETLDataSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ETLDataSourceMapper {
    int countByExample(ETLDataSourceExample example);

    int deleteByExample(ETLDataSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ETLDataSource record);

    int insertSelective(ETLDataSource record);

    List<ETLDataSource> selectByExample(ETLDataSourceExample example);

    ETLDataSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ETLDataSource record, @Param("example") ETLDataSourceExample example);

    int updateByExample(@Param("record") ETLDataSource record, @Param("example") ETLDataSourceExample example);

    int updateByPrimaryKeySelective(ETLDataSource record);

    int updateByPrimaryKey(ETLDataSource record);
}