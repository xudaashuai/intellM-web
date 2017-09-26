package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.DataCheckRule;
import com.cug.intellM.web.po.DataCheckRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCheckRuleMapper {
    int countByExample(DataCheckRuleExample example);

    int deleteByExample(DataCheckRuleExample example);

    int deleteByPrimaryKey(Integer checkrule);

    int insert(DataCheckRule record);

    int insertSelective(DataCheckRule record);

    List<DataCheckRule> selectByExample(DataCheckRuleExample example);

    DataCheckRule selectByPrimaryKey(Integer checkrule);

    int updateByExampleSelective(@Param("record") DataCheckRule record, @Param("example") DataCheckRuleExample example);

    int updateByExample(@Param("record") DataCheckRule record, @Param("example") DataCheckRuleExample example);

    int updateByPrimaryKeySelective(DataCheckRule record);

    int updateByPrimaryKey(DataCheckRule record);
}