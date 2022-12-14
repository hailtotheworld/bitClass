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
		
		
		/*
		//↓단일파일업로드//////////////////////////////////////////////////////////////////////////////////
		
		Part filePart = request.getPart("file");
		// request.getParameter("title")는 전달된 것의 문자열을 받는다.
		// request.getPart("file");는 특정 part를 받는것이다. 바이너리라고하는 컨텐츠를 받는거다.
		String fileName = filePart.getSubmittedFileName();
		// 파일명을 얻는방법
		
		InputStream fis = filePart.getInputStream();
		// InputStream이 있으면 파일을 저장할수있다. 스트림을 통해서 파일을 전달받는거다. 입력받기위한 버퍼다.
		// InputStream은 인터페이스다. System.in도 InputStream인터페이스를 구현받았다. 그러니 상속받은 같은 메서드를 사용하지.
		
		String realPath = request.getServletContext().getRealPath("/upload");
		// ServletContext 객체를 이용해서 .getRealPath("상대경로")를 넘겨주면 절대경로를 반환해준다. Gets the real path corresponding to the given virtual path. 
		// 저장경로는 상대경로를 쓸수없다. 실제 저장되는 절대경로를 써줘야 한다.
		// 파일을 저장하기위한 자바가 제공하고있는 플랫폼의 API가 절대경로를 쓸수밖에 없기때문에 그렇다.
		// System.out.println(realPath); 로 경로를 확인해보면
		// C:\Users\TH\Documents\GitHub\bitClass\(JSP)\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\JspPrj\ upload
		// 이클립스에 있는 Project Explorer과는 다른거다. 이클립스에 있는 탐색기는 개발하기 위한 워크스페이스에 있는 디렉토리이지, 실제 저장장소가 아니야.
		// 코드가 개발할때 사용했던 워크스페이스에 있는게 아니라 임시서비스를 위한 배포서비스로 옮겨지게 된다. 개발하고 있는 개발폴더에 업로드되는 일은 없다.
		// 이클립스가 운영하고 있는 서비스를위해사용되는배포서버가 C:\Users\TH\Documents\GitHub\bitClass\(JSP)\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\JspPrj\ 안에 저장되는거다.
		// 서비스되고 있는 어플리케이션에 업로드가 되는거다.
		// (해당폴더없어서 오류떠가지고, 폴더를 직접만들었더니 해결됐다)
		
		String filePath = realPath + File.separator + fileName;
		// realPath -> C:\Users\TH\Documents\GitHub\bitClass\(JSP)\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\JspPrj\ upload
		// File.separator -> 경로가 유닉스에서는 슬래시, 윈도우에서는 역슬래시가 붙는다. 현재 시스템에서 사용되는 경로구분방법을 문자로 반환해준다.
		// fileName -> 실제 업로드한 파일의 이름.
		
		FileOutputStream fos = new FileOutputStream(filePath);
		// 출력하기위한 버퍼
		
		// int b = fis.read();
		// .read()가 1바이트씩 읽어준다. 실제 반환하는건 byte타입이다.
		// 그런데 반환하는 타입은 int타입이다. 다 읽었다고 표현하기 위해서 -1을 반환하기때문이다. Returns:the next byte of data, or -1 if the end of thestream is reached.
		
		
		// int b; // 읽은걸 담아놓는그릇이다.
		// while((b=fis.read()) != -1) {
		//	 fos.write(b);
		// }
		// 이렇게하면 1바이트씩 읽어서 1바이트씩 쓰는거라서 시간이 굉장히 오래 걸린다. 마치 티스푼으로 양동이 물 옮기는거처럼.
		
		byte[] buf = new byte[1024]; // 바가지로 퍼서 올리는거야
		int size = 0; // 읽어온 데이터바이트의 개수를 알려준다
		while((size = fis.read(buf)) != -1) {
		//	fos.write(buf); // buf크기만큼 담겨져있는걸 다 쓰는거야. 예를들어서 300개 읽어도 1024를 쓰는거지.
			fos.write(buf,0,size); // 0번째부터,size길이만큼읽어들이는거다
		}
		
		fos.close();
		fis.close();
		
		//↑단일파일업로드//////////////////////////////////////////////////////////////////////////////////
		*/

		//↓다중파일업로드//////////////////////////////////////////////////////////////////////////////////
		
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		
		for(Part filePart : parts) {
			if(!filePart.getName().equals("file")) continue;
			if(filePart.getSize()==0) continue; // 파일을 하나만 혹은 아예 입력하지 않았을때도 정상적으로 글등록하게 하기위해.
								
			InputStream fis = filePart.getInputStream();

			
			String fileName = filePart.getSubmittedFileName();
			builder.append(fileName); //
			builder.append(","); //
			
			String realPath = request.getServletContext().getRealPath("/upload");
			  File path = new File(realPath);
			  // 실제 realPath가 있는지 알아보고 없으면 만드는작업도 해야한다.
			  if(!path.exists()) {
				  // path.mkdir();  // 경로끝에 있는 물리적인경로만 만든다.
				  path.mkdirs(); // 부모path까지 다 만들어준다
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
	
		// Notice notice = new Notice();
		// notice.setFiles(builder.toString()); //builder.toString()을 넣어주는구나..!
		
		//↑다중파일업로드//////////////////////////////////////////////////////////////////////////////////
		
		
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriterId("newlec"); //인증권한배우고 바꿀거야.
		notice.setPub(pub);
		notice.setFiles(builder.toString());  //builder.toString()을 넣어주는구나..!
		
		NoticeService service = new NoticeService();
		int result = service.insertNotice(notice);
		
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