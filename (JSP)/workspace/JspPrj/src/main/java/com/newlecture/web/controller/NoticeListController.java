package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Param;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

						
		String field_ = request.getParameter("f"); // 가져온값이 null일수있으니까 일단 임시변수에 담아둬.
		String query_ = request.getParameter("q");
		
		String field = "title";                   // 진짜사용할변수에 기본값 담아줘.
		if(field_!=null && !field_.equals("")) {
			field = field_;
		}                                          // 임시변수가 null이 아닐때만 임시변수를 진짜변수에 담아줘

		String query = "";
		if(query_!=null && !query_.equals("")) {
			query = query_;
		}
		
		NoticeService service = new NoticeService();
		
		List<Notice> list = service.getNoticeList(field, query, 1);
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
		dispatcher.forward(request, response);
		


	}

}