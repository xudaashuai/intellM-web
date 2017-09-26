package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.UserStrategyExample;
import com.cug.intellM.web.po.UserStrategyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStrategyMapper {
    int countByExample(UserStrategyExample example);

    int deleteByExample(UserStrategyExample example);

    int deleteByPrimaryKey(UserStrategyKey key);

    int insert(UserStrategyKey record);

    int insertSelective(UserStrategyKey record);

    List<UserStrategyKey> selectByExample(UserStrategyExample example);

    int updateByExampleSelective(@Param("record") UserStrategyKey record, @Param("example") UserStrategyExample example);

    int updateByExample(@Param("record") UserStrategyKey record, @Param("example") UserStrategyExample example);
}