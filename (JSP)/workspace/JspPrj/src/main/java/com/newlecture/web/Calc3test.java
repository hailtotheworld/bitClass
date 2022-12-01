package com.newlecture.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3test")
public class Calc3test extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operator = request.getParameter("operator");
		String value = request.getParameter("value");
		String dot =request.getParameter("dot");
		
		String exp = "";
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null)
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		
		if(operator!=null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			exp+=(operator==null)?"":operator;
			exp+=(value==null)?"":value;
			exp+=(dot==null)?"":dot;
		}
		
		Cookie cookie = new Cookie("exp",exp);
		response.addCookie(cookie);
		response.sendRedirect("calcpagetest");
	}

}
