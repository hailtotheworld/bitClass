package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8"); // 서버가 UTF-8로 보내겠다.
		response.setContentType("text/html; charset=UTF-8"); // 클라이언트야 이문서는 HTML문서다. UTF-8로 읽어라.
		//모든 응답에 콘텐츠타입이 css나 image라 할지라도 text/html로 고정되서 위 setContentType메서드는 필터클래스에 넣지 않아야 한다.
		
		
		PrintWriter out = response.getWriter();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
		
	}

}
