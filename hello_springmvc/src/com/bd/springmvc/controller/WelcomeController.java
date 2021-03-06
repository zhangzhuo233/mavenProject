package com.bd.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: hello_springmvc
 * @description: Controller
 * @author: Mr.zhang
 * @create: 2019-08-08 20:45
 **/
@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome")
    public String welcome(@RequestParam String name) {
        System.out.println("welcome jsp...");
        System.out.println("Welcome:" + name);
        return "welcome";
    }
}
