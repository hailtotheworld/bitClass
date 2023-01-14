package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
         public class HomeController {

             @GetMapping("")
             public String home(Model model) {
                 model.addAttribute("data","template동적인페이지입니다");
                 return "home";
             }

             @GetMapping("index")
             public String index(Model model) {
                 model.addAttribute("data","인덱스페이지입니다");
                 return "index";
             }

             @GetMapping("hello")
             public String hello(Model model) {
                 model.addAttribute("data","Spring~!");
        return "hello"; //  /resources/templates/ hello .html
     }


}