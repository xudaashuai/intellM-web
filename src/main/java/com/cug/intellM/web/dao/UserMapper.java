package com.cug.intellM.web.dao;

import java.util.List;
import com.cug.intellM.web.po.User;

/** 
 * @author xiadc 
 * createtime��2017��4��10�� ����3:57:24 
 * ��˵�� 
 */
public interface UserMapper {

	List<User> findUser();
}
