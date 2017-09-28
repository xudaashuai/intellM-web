package com.cug.intellM.web.controller;


import com.cug.intellM.web.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController extends BaseController {

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ResponseBody // 登录
    Map<Object,Object> login(@RequestParam String username, @RequestParam String password, HttpServletResponse response, HttpSession session){
        System.out.println(username+" "+password+" try login");
        Map<Object,Object> result=new HashMap<Object,Object>();
        if (userService.checkloginName(username)){
            if(userService.checkPassword(username,password)){
                result.put("status",0);
                User u = userService.getUserByLoginName(username);
                if (u==null) {
                    // 奇妙错误
                    result.put("status",-1);
                }
                else {
                    Cookie cookie = new Cookie("user",username+"#"+password);
                    cookie.setMaxAge(1000*24*7*3600);
                    response.addCookie(cookie);
                    User user = userService.getUserByLoginName(username);
                    result.put("user", user);
                    session.setAttribute("admin",user.getUserType()==1);
                    // todo 从数据库中载入用户界面并返回
                }
            }else{
                // 密码错误
                result.put("status",500);
            }
        }else{
            // 用户名不存在
            result.put("status",400);
        }
        return result;
    }
    @RequestMapping(path = "/reg",method = RequestMethod.POST)
    @ResponseBody // 注册
    Map<Object,Object> reg(@RequestParam String username, @RequestParam String password){
        Map<Object,Object> result=new HashMap<Object,Object>();
        if (userService.checkloginName(username)){
            // 用户名已存在
            result.put("status",401);
        }else{
            if (userService.insertUser(username,0,username,password,"0")){
                // 注册成功
                result.put("status",0);
            }else{
                // 奇妙错误
                result.put("status",-1);
            }
        }
        return result;
    }
    @RequestMapping(path = "/forge_password",method = RequestMethod.POST)
    @ResponseBody // 忘记密码
    Map<Object,Object> forgetPassword(@RequestParam String username){
        Map<Object,Object> result=new HashMap<Object,Object>();
        // TODO: 2017/9/18 完成忘记密码功能
        return result;
    }
    @RequestMapping(path = "/logout")
    @ResponseBody // 忘记密码
    Map<Object,Object> logout( HttpServletResponse response,HttpSession session){
        Map<Object,Object> result=new HashMap<Object,Object>();
        response.addCookie(new Cookie("user",""));
        session.setAttribute("admin",false);
        //
        return result;
    }
}
