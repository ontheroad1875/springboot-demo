package com.huly.springboot.controller;

/**
 * TODO
 *
 * @author huluy
 * @date 2020/8/11 16:00
 */
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "Hi~欢迎");
        return "home";
    }
    @RequestMapping("/login")
    public  String login(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("权限:" + authentication);
        return "login";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }
}