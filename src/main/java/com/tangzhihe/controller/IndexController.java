package com.tangzhihe.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 主页
 */

@Controller
public class IndexController  extends  AbstractController{

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "mainPage";
    }
}
