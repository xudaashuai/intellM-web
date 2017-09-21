package com.cug.intellM.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
    @RequestMapping(path = "/")
    public String m(){
        return "index";
    }
    @RequestMapping(path = "/{src}")
    public String src(@PathVariable String src){
        return src;
    }
}
