package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginSayfasi() {
        return "login"; // resources/templates/login.html olmalı
    }

    @GetMapping("/home")
    public String homeSayfasi() {
        return "home";  // resources/templates/home.html olmalı
    }
}
