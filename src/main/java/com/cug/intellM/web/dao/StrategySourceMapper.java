package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.StrategySourceExample;
import com.cug.intellM.web.po.StrategySourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategySourceMapper {
    int countByExample(StrategySourceExample example);

    int deleteByExample(StrategySourceExample example);

    int deleteByPrimaryKey(StrategySourceKey key);

    int insert(StrategySourceKey record);

    int insertSelective(StrategySourceKey record);

    List<StrategySourceKey> selectByExample(StrategySourceExample example);

    int updateByExampleSelective(@Param("record") StrategySourceKey record, @Param("example") StrategySourceExample example);

    int updateByExample(@Param("record") StrategySourceKey record, @Param("example") StrategySourceExample example);
}