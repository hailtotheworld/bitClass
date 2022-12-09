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

		// 사용자가 요청한 것을 받는것이 컨트롤러가 하는 역할이다
		String field_ = request.getParameter("f"); // 가져온값이 null일수있으니까 일단 임시변수에 담아둬.
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p"); // 넘어온값이 null일수있으니 우선은 String으로 받고, null이아닐때 int로 바꿔줄거야.
		                                          // int는 null을 받을수있는 자료형이 아니다.
		
		
		// 넣을수도 있고 안넣을수도 있는 값들이니까, 안넣었을때를 대비해 기본값이 필요하다.	
		String field = "title";                   // 진짜사용할변수에 기본값 담아줘.
		if(field_!=null && !field_.equals("")) {
			field = field_;
		}                                          // 임시변수가 null이 아닐때만 임시변수를 진짜변수에 담아줘

		String query = ""; // 기본값설정
		if(query_!=null && !query_.equals("")) {
			query = query_;
		}
		
		int page = 1; // 기본값설정
		if(page_!=null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		NoticeService service = new NoticeService();
		
		List<Notice> list = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);
		
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
		dispatcher.forward(request, response);
		


	}

}