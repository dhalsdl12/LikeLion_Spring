package com.jpaShop.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/") // url
    public String home(){
        return "home"; // home.html
    }
}
