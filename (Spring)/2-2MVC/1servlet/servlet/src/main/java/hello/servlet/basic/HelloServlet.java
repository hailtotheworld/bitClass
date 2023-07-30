package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns="/hello") // 서블릿이름이나 url매핑은 겹치면안된다(중복이 있으면 안된다)
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //////////////////////////////////////////////////////
        String username = request.getParameter("username"); // 쿼리파라미터를 편리하게 조회할수가 있다. http메시지에 있는걸 직접 다 파싱해서 읽는다면 굉장히 괴롭지ㅠ
        System.out.println("username = " + username);

        //////////////////////////////////////////////////////
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); // 옛날시스템아니면 지금은 utf-8을 써야한다.
        response.getWriter().write("hello " + username); //http메시지 바디에 메시지가 들어간다.



    }



}
