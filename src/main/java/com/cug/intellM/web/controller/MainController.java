package com.cug.intellM.web.controller;


import com.cug.intellM.web.po.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller

public class MainController extends BaseController {
    @RequestMapping(path = "/")
    public String m(@CookieValue(value = "user", defaultValue = "") String cookie, Model view, HttpSession session) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String[] loginInfo = cookie.split("#");
        if (loginInfo.length == 2 && userService.checkPassword(loginInfo[0], loginInfo[1])) {
            User user = userService.getUserByLoginName(loginInfo[0]);
            view.addAttribute("user", mapper.writeValueAsString(user));
            session.setAttribute("admin",user.getUserType()==1);
        }else{
            view.addAttribute("user", false);
        }
        return "index";
    }

    @RequestMapping(path = "/{src}")
    public String src(@PathVariable String src, @SessionAttribute("admin") boolean admin) {
        if (admin) {
            if (src.equals("moal_config"))
                return "moal_config_admin";
        }
        return src;
    }
}
