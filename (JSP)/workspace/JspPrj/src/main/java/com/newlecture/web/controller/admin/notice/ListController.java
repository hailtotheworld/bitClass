package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;
import com.oracle.js.parser.ir.RuntimeNode.Request;

/*

http://localhost:8080/admin/board/notice/list

*/

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 키s가같은데 값이다르면 배열로온다.
		String[] openIds = request.getParameterValues("open-id"); // 체크선택된 id들이 전달되서 만들어진 배열
		String[] delIds_ = request.getParameterValues("del-id");
		// value값                                    name키
		String cmd = request.getParameter("cmd");
		
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.trim().split(" "); // 전체id저장된 배열
		// .trim()으로 앞뒤공백없애주고 - .split(" ")로 공백별로 나눠서 배열에 저장한다.
		
		
		NoticeService service = new NoticeService();

		switch (cmd) {
		case "일괄공개":
			for (String openId : openIds) {
				System.out.printf("openId: %s\n", openId);
			}
			
			List<String> openIdsList = Arrays.asList(openIds);
			// 배열을 List형태로 바꿔준다
			// 왜바꾸냐고? .contains메서드를 사용하기위해서 List로 바꿔주는거다.
			
			for(int i=0;i<ids.length;i++) {
				// 1. 현재 id가 open된 상태인지확인해야지
				if(openIdsList.contains(ids[i])) {
					
				} else {
					
				}
			}
			
			service.pubNoticeList(opnIds);
			service.closeNoticeList(clsIds);
			
			
			break;

		case "일괄삭제":
			int[] delIds = new int[delIds_.length];
//			(x) int[] delIds = new int[]; //배열길이안정해서 컴파일오류
//			(x) int[] delIds = null; //이렇게 지정하면 안된다.

			for (int i=0;i<delIds_.length;i++) {
				delIds[i] = Integer.parseInt(delIds_[i]);
			}
			
			int result = service.deleteNoticeAll(delIds);			
			
			break;
		}
				
		// get방식으로 다시 같은 url로 돌려준다
		response.sendRedirect("/admin/board/notice/list"); 

	}

	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 사용자가 요청한 것을 받는것이 컨트롤러가 하는 역할이다
		String field_ = request.getParameter("f"); // 가져온값이 null일수있으니까 일단 임시변수에 담아둬.
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p"); // 넘어온값이 null일수있으니 우선은 String으로 받고, null이아닐때 int로 바꿔줄거야.
													// int는 null을 받을수있는 자료형이 아니다.

		// 넣을수도 있고 안넣을수도 있는 값들이니까, 안넣었을때를 대비해 기본값이 필요하다.
		String field = "title"; // 진짜사용할변수에 기본값 담아줘.
		if (field_ != null && !field_.equals("")) {
			field = field_;
		} // 임시변수가 null이 아닐때만 임시변수를 진짜변수에 담아줘

		String query = ""; // 기본값설정
		if (query_ != null && !query_.equals("")) {
			query = query_;
		}

		int page = 1; // 기본값설정
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		NoticeService service = new NoticeService();

		List<NoticeView> list = service.getNoticeViewList(field, query, page);
		int count = service.getNoticeCount(field, query);

		request.setAttribute("list", list);
		request.setAttribute("count", count);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp");
		dispatcher.forward(request, response);
	}

}