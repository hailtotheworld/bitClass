package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();

		// (3)클라이언트에게서 전달된 쿠키를 읽는다.
		Cookie[] cookies = request.getCookies();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;

		if (v_ != null && !v_.equals("")) {
			v = Integer.parseInt(v_);
		}

		// 계산
		if (op.equals("=")) {

//			int x = (int) application.getAttribute("value");
//			int x = (int) session.getAttribute("value");

			// (4) 받은 쿠키들에서 이름이 같은쿠키를 찾아서 값을 대입한다.
			int x = 0;
			for (Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			

			int y = v;
//			String operator = (String) application.getAttribute("op");
//			String operator = (String) session.getAttribute("op");
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			
			int result = 0;

			if (operator.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}

			out.printf("result is %d\n", result);

		}
		// 값을 저장
		else {
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);

//			session.setAttribute("value", v);
//			session.setAttribute("op", op);

			// (1)쿠키를 만든다.
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			// (1-1) 쿠키가 클라이언트에서 서버로 올때 경로를 제한할수있다.
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");
			
			// (1-2) 쿠키가 값을 유지하는 기간을 설정할수있다. 브라우저를 닫아도 유지된다.
			valueCookie.setMaxAge(7*24*60*60); //Sets the maximum age in seconds for this Cookie. 초단위다
			

			// (2)쿠키를 클라이언트에 보낸다
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc3.html");

		}

	}

}
