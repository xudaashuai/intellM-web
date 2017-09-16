package com.cug.intellM.web.dao;

import java.util.List;
import com.cug.intellM.web.po.User;

/** 
 * @author xiadc 
 * createtime：2017年4月10日 下午3:57:24 
 * 类说明 
 */
public interface UserMapper {

	List<User> findUser();
}
