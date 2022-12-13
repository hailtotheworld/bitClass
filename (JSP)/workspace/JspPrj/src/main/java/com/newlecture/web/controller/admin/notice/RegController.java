package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;



@MultipartConfig(
fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*50,
maxRequestSize = 1024*1024*50*5
)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		// 기본값을 넣어야하는지 고민해봐. 지금의 경우에는 기본값 안넣어도 되겠구나.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String isOpen = request.getParameter("open");
		boolean pub = false;
		if(isOpen!=null) {
			pub = true;
		}
		
		////////////////////////////////////////////////////////////////////////////////////
		
		Part filePart= request.getPart("file");
		// request.getParameter("title")는 전달된 것의 문자열을 받는다.
		// request.getPart("file");는 특정 part를 받는것이다. 바이너리라고하는 컨텐츠를 받는거다.
		
		filePart.getInputStream();
		// InputStream이 있으면 파일을 저장하는데는 문제가 없다. 스트림을 통해서 파일을 전달받는거다.
		
		request.getServletContext().getRealPath("/upload");
		// ServletContext 객체를 이용해서 .getRealPath("상대경로")를 넘겨주면 절대경로를 반환해준다. Gets the real path corresponding to the given virtual path. 
		// 저장경로는 상대경로를 쓸수없다. 실제 저장되는 절대경로를 써줘야 한다.
		// 파일을 저장하기위한 자바가 제공하고있는 플랫폼의 API가 절대경로를 쓸수밖에 없기때문에 그렇다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriterId("newlec"); //인증권한배우고 바꿀거야.
		notice.setPub(pub);
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		/*
		PrintWriter out = response.getWriter();
		out.printf("%s\n",title);
		out.printf("%s\n",content);
		out.printf("%s\n",isOpen);
		*/
		
		response.sendRedirect("list");
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp");
		dispatcher.forward(request, response);
	}

}