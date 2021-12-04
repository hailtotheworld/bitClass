package first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get 요청 처리!!!");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<title>Servlet</title>");
		resp.getWriter().println("</head>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>Get Request !!!</h1>"); // 자바코드로 html 형식을 만드는거야.
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
	
	// 서블릿 웹페이지 응답을 만들지 않는다. 너무 복잡하고 힘들잖아.

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	

}
