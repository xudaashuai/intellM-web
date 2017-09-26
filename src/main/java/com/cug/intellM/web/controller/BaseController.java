package com.cug.intellM.web.controller;

import com.cug.intellM.web.dao.UserMapper;
import com.cug.intellM.web.po.AlgorithmParameter;
import com.cug.intellM.web.po.ModelAlgorithm;
import com.cug.intellM.web.po.User;
import com.cug.intellM.web.po.UserExample;
import com.cug.intellM.web.service.AlgorithmService;
import com.cug.intellM.web.service.ModelAlgorithmService;
import com.cug.intellM.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {
    @Autowired
    UserService userService;
    @Autowired
    AlgorithmService algorithmService;
    @Autowired
    ModelAlgorithmService modelAlgorithmService;
    UserExample userExample=new UserExample();
    final Log logger = LogFactory.getLog(this.getClass());
}
