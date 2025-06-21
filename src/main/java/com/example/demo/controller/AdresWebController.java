package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adresler")
public class AdresWebController {

    @GetMapping
    public String showAdresListesi() {
        return "adresler"; // templates/adresler.html
    }
}
