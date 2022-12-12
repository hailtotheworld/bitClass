package com.newlecture.web.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 

http://localhost:8080/admin/index



*/

@WebServlet("/admin/index")
public class IndexController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/index.jsp");
		dispatcher.forward(request, response);
	}

}