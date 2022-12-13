package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entitiy.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/notice/reg")
public class RegController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		boolean pub = false;
		if(isOpen != null) {
			pub = true;
		}
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		
		NoticeService service = new NoticeService();
		
		service.insertNotice(notice);
		
		response.sendRedirect("list");
		

	}

}
