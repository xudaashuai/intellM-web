package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.EnglineerEvaluate;
import com.cug.intellM.web.po.EnglineerEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnglineerEvaluateMapper {
    int countByExample(EnglineerEvaluateExample example);

    int deleteByExample(EnglineerEvaluateExample example);

    int insert(EnglineerEvaluate record);

    int insertSelective(EnglineerEvaluate record);

    List<EnglineerEvaluate> selectByExample(EnglineerEvaluateExample example);

    int updateByExampleSelective(@Param("record") EnglineerEvaluate record, @Param("example") EnglineerEvaluateExample example);

    int updateByExample(@Param("record") EnglineerEvaluate record, @Param("example") EnglineerEvaluateExample example);
}