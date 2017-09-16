package com.cug.intellM.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.User;
import com.cug.intellM.web.service.UserService;

/** 
 * @author xiadc 
 * createtime：2017年4月10日 下午4:11:41 
 * 类说明 
 */

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public List<User> findUser() {
		return  userMapper.findUser();		
	}

}
