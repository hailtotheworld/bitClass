package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entitiy.NoticeView;
import com.newlecture.web.service.NoticeService;

/*
http://localhost:8080/JspClonePrj/admin/board/notice/list
 */

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");

		String field = "title";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		String query = "";
		if (query_ != null && !query_.equals("")) {
			query = query_;
		}

		int page = 1;
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);

		request.setAttribute("list", list);
		request.setAttribute("count", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp");
		dispatcher.forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] openIds = request.getParameterValues("open");
		String[] delIds = request.getParameterValues("del");
		String cmd = request.getParameter("cmd");
		String[] ids = request.getParameterValues("ids");
		
		NoticeService service = new NoticeService();
		
		switch (cmd) {
		case "일괄공개":

			List<String> openIdsList = Arrays.asList(openIds);
			
			List<String> closeIdsList = new ArrayList<>(Arrays.asList(ids));
			
			closeIdsList.removeAll(openIdsList);
			
			service.updatePubList(openIdsList,closeIdsList);
			
			break;

		case "일괄삭제":
			

			
			int[] delId = new int[delIds.length];
			
			for(int i=0;i<delId.length;i++) {
				delId[i] =  Integer.parseInt(delIds[i]);
			}
			
			service.removeNoticeAll(delId);
			
			break;
		}
		
		
		response.sendRedirect("list");


		

				
	
	}

}
