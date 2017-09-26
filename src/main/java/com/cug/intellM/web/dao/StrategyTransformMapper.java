package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.StrategyTransformExample;
import com.cug.intellM.web.po.StrategyTransformKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyTransformMapper {
    int countByExample(StrategyTransformExample example);

    int deleteByExample(StrategyTransformExample example);

    int deleteByPrimaryKey(StrategyTransformKey key);

    int insert(StrategyTransformKey record);

    int insertSelective(StrategyTransformKey record);

    List<StrategyTransformKey> selectByExample(StrategyTransformExample example);

    int updateByExampleSelective(@Param("record") StrategyTransformKey record, @Param("example") StrategyTransformExample example);

    int updateByExample(@Param("record") StrategyTransformKey record, @Param("example") StrategyTransformExample example);
}