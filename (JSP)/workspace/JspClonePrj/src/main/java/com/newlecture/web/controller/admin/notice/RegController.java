package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entitiy.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(
fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*50,
maxRequestSize = 1024*1024*50*5
)
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
		
		Collection<Part> fileParts = request.getParts();
		StringBuilder builder = new StringBuilder();
		
		for(Part filePart : fileParts) {
			if(!filePart.getName().equals("file")) continue;
			if(filePart.getSize()==0) continue;
			
			InputStream fis = filePart.getInputStream();
			
			String fileName = filePart.getSubmittedFileName();
			builder.append(fileName);
			builder.append(",");
			String realPath = request.getServletContext().getRealPath("/upload");
			File fileFolder = new File(realPath);
			if(!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			String filePath = realPath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fos.close();
			fis.close();
		}

		builder.delete(builder.length()-1, builder.length());
		

		
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setFiles(builder.toString());
		
		NoticeService service = new NoticeService();
		
		service.insertNotice(notice);
		
		response.sendRedirect("list");
		

	}

}
