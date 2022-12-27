package com.newlecture.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class HomeController {

	@RequestMapping("/index")
	public String index() {
		return "root.index";
	}
}