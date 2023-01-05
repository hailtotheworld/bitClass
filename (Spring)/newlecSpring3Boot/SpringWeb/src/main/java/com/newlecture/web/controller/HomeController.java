package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("index")
	@ResponseBody
	public String index() { 
		//스프링에서 컨트롤러의 함수명은 사용되지 않는다.
		// 어노테이션의 url매핑을 찾아서 함수를 호출하니까 함수명은 url매핑과 관련이 없는거다.
		return "Hello";
	}
	
	@GetMapping("help")
	@ResponseBody
	public String help() { 
		return "헬프미";
	}
	

}
