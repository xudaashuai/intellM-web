package com.cug.intellM.web.dao;

import com.cug.intellM.web.po.UserSourceExample;
import com.cug.intellM.web.po.UserSourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSourceMapper {
    int countByExample(UserSourceExample example);

    int deleteByExample(UserSourceExample example);

    int deleteByPrimaryKey(UserSourceKey key);

    int insert(UserSourceKey record);

    int insertSelective(UserSourceKey record);

    List<UserSourceKey> selectByExample(UserSourceExample example);

    int updateByExampleSelective(@Param("record") UserSourceKey record, @Param("example") UserSourceExample example);

    int updateByExample(@Param("record") UserSourceKey record, @Param("example") UserSourceExample example);
}