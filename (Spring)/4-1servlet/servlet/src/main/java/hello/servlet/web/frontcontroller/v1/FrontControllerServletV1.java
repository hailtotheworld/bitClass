package hello.servlet.web.frontcontroller.v1;

import hello.servlet.basic.HelloServlet;
import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSavaControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*") //어떤 url이 들어오든 우선은 일단 프론트컨트롤러에 매핑된다.
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String,ControllerV1> controllerMap = new HashMap<>();//키는 url, 밸류는 컨트롤러

    public FrontControllerServletV1() {
        // 이 프론트컨트롤러가 생성될때 매핑정보를 담아놓는다.
        controllerMap.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save",new MemberSavaControllerV1());
        controllerMap.put("/front-controller/v1/members",new MemberListControllerV1());
        // 해당 url로 접속이오면, 객체를 꺼내쓸수있게 미리 생성해둔거다.
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(request,response);
    }
}
