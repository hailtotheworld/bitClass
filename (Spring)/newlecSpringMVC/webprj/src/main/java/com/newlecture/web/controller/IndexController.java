package com.newlecture.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
http://localhost:8080/index
 */

public class IndexController implements Controller{


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("index controller");
		
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("/WEB-INF/view/index.jsp");
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("data", "Hello Spring MVC");
		
		return mv;
	}
	
}
