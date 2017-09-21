package com.cug.intellM.web.controller;

import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.UserExample;
import com.cug.intellM.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseController {
    @Autowired
    UserService userService;
    UserExample userExample=new UserExample();
    final Log logger = LogFactory.getLog(this.getClass());
}
