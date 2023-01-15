package com.example.web.hellospringclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data","안녕 스프링~!");
        return "index";
    }
}
