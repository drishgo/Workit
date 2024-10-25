package com.Workit.Workit.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProfileController {

    @RequestMapping("/")
    public String greet(HttpServletRequest request){
        return "Hello"+ request.getSession().getId();
    }
}
