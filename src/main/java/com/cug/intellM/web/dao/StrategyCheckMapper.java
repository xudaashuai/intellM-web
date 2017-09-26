package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.StrategyCheck;
import com.cug.intellM.web.po.StrategyCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyCheckMapper {
    int countByExample(StrategyCheckExample example);

    int deleteByExample(StrategyCheckExample example);

    int deleteByPrimaryKey(Integer strategyid);

    int insert(StrategyCheck record);

    int insertSelective(StrategyCheck record);

    List<StrategyCheck> selectByExample(StrategyCheckExample example);

    StrategyCheck selectByPrimaryKey(Integer strategyid);

    int updateByExampleSelective(@Param("record") StrategyCheck record, @Param("example") StrategyCheckExample example);

    int updateByExample(@Param("record") StrategyCheck record, @Param("example") StrategyCheckExample example);

    int updateByPrimaryKeySelective(StrategyCheck record);

    int updateByPrimaryKey(StrategyCheck record);
}