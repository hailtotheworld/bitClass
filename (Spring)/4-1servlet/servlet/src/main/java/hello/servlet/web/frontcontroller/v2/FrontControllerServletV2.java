package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSavaControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*") //어떤 url이 들어오든 우선은 일단 프론트컨트롤러에 매핑된다.
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();//키는 url, 밸류는 컨트롤러

    public FrontControllerServletV2() {
        // 이 프론트컨트롤러가 생성될때 매핑정보를 담아놓는다.
        controllerMap.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save",new MemberSavaControllerV2());
        controllerMap.put("/front-controller/v2/members",new MemberListControllerV2());
        // 해당 uri로 접속이오면, 객체를 꺼내쓸수있게 미리 생성해둔거다.
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request,response);
    }
}
