package com.cug.intellM.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cug.intellM.web.po.User;
import com.cug.intellM.web.service.UserService;

/** 
 * @author xiadc 
 * createtime��2017��4��10�� ����4:15:42 
 * ��˵�� 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public void getUser(){
		
		List<User> list =  userService.findUser();
		//ModelAndView mv = new ModelAndView();
		for(User user :list){
			System.out.println(user);
		}
		//System.out.println(list);
//		mv.addObject("list", list);
//		mv.setViewName("showUser");
		
	}
}
