package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.TransformRule;
import com.cug.intellM.web.po.TransformRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransformRuleMapper {
    int countByExample(TransformRuleExample example);

    int deleteByExample(TransformRuleExample example);

    int deleteByPrimaryKey(Integer transRule);

    int insert(TransformRule record);

    int insertSelective(TransformRule record);

    List<TransformRule> selectByExample(TransformRuleExample example);

    TransformRule selectByPrimaryKey(Integer transRule);

    int updateByExampleSelective(@Param("record") TransformRule record, @Param("example") TransformRuleExample example);

    int updateByExample(@Param("record") TransformRule record, @Param("example") TransformRuleExample example);

    int updateByPrimaryKeySelective(TransformRule record);

    int updateByPrimaryKey(TransformRule record);
}