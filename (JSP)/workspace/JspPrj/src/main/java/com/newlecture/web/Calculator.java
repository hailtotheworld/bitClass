package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * if(request.getMethod().equals("GET")) { System.out.println("GET 요청이 왔습니다.");
	 * } else if (request.getMethod().equals("POST")) {
	 * System.out.println("POST 요청이 왔습니다."); }
	 * 
	 * super.service(request, response);
	 * 
	 * }
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2)post된 값을 받는다
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		// 6)클라이언트에서 자동으로 보내진쿠키를 받아서 쿠키이름에 맞는값을꺼낸다.
		Cookie[] cookies = request.getCookies();
		String exp = "";
		if (cookies != null)
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}

		// 3)받은값을 누적시킨다.
		if (operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}

		// 4)누적시킨값을 쿠키로만들어서 클라이언트에 보낸다.
		Cookie expCookie = new Cookie("exp", exp);
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		response.sendRedirect("/calculator"); // GET방식으로 보내는거야.
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 5)서버에서 보낸 쿠키를 받아서 쿠키이름에 맞는값을꺼낸다.
		Cookie[] cookies = request.getCookies();
		String exp = "0";
		if(cookies != null)
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		
		// 1)post로 서버에 값을 보낸다.
		out.write("");
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input {");
		out.write("	width: 50px;");
		out.write("	height: 50px;");
		out.write("}");
		out.write(".output {");
		out.write("	height: 50px;");
		out.write("	background: #e9e9e9;");
		out.write("	font-size: 24px;");
		out.write("	font-weight: bold;");
		out.write("	text-align: right; ");
		out.write("	padding: 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form method=\"post\">"); // action=\"calc3\" 삭제가능하다. 자기페이지를 요청하는거니까
		out.write("		<table>");
		out.write("			<tr>");
		out.printf("				<td class=\"output\" colspan=\"4\">%s</td>",exp);
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"/\" /></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"*\" /></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"4\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"-\" /></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"+\" /></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"dot\" value=\".\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");

	}

}
