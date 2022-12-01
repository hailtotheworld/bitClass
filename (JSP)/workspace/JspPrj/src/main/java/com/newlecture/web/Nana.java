package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nana")
public class Nana extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8"); // 서버가 UTF-8로 보내겠다.
		response.setContentType("text/html; charset=UTF-8"); // 클라이언트야 이문서는 HTML문서다. UTF-8로 읽어라.

		PrintWriter out = response.getWriter();

		String cnt_ = request.getParameter("cnt");
		
		int cnt = 100;
		if(cnt_!=null && !cnt_.equals("")) {
			cnt = Integer.parseInt(cnt_);
		}
		
		for (int i = 0; i < cnt; i++) {
			out.print((i+1)+": 안녕 Servlet <br>");
		}

	}

}
