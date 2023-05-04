package com.example.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloSpringController {
    @GetMapping("hello-spring")
    public String helloStatic(Model model, @RequestParam(name="str") String str){
        model.addAttribute("data", str);

        return "hello-spring";
    }
}
