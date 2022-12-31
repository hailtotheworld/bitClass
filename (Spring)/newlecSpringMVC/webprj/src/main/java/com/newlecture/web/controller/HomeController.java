package com.newlecture.web.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*

http://localhost:8080/index

*/

/*
public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//System.out.println("index controller");
		
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("/WEB-INF/view/index.jsp");
		ModelAndView mv = new ModelAndView("root.index");

		mv.addObject("data", "Hello Spring MVC");
		
		return mv;
	}
}
*/


@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	public String index() {
		return "root.index";
	}
	
//	@RequestMapping("index")
//	public void index(HttpServletResponse response) throws IOException {
//		PrintWriter out = response.getWriter();
//		out.println("Hello Index");
//	}
	
//	@RequestMapping("index")
//	@ResponseBody //@ResponseBody가 있어야지 view로 가지 않고, 문자열자체가 사용자에게 가길 원한다고 알려주는거다.
//	public String index()  {
//		return "Hello Index1";
//	}
	
}