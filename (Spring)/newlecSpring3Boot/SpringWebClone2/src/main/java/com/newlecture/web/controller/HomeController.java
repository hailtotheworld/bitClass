package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("index")
	public String index() {
		return "index"; 
	}

}


/*
spring.mvc.view.prefix=/WEB-INF/view/
spring.mvc.view.suffix=.jsp
*/