package hello.servlet.web.frontcontroller.v4;


import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSavaControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*") //어떤 url이 들어오든 우선은 일단 프론트컨트롤러에 매핑된다.
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();//키는 url, 밸류는 컨트롤러

    public FrontControllerServletV4() {
        // 이 프론트컨트롤러가 생성될때 매핑정보를 담아놓는다.
        controllerMap.put("/front-controller/v4/members/new-form",new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save",new MemberSavaControllerV4());
        controllerMap.put("/front-controller/v4/members",new MemberListControllerV4());
        // 해당 uri로 접속이오면, 객체를 꺼내쓸수있게 미리 생성해둔거다.
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>(); // (2)여기서 그냥 쓰면된다..!
        String viewName = controller.process(paramMap, model); // (1) 컨트롤러에서 모델에 값을담은거를

        MyView view = viewResolver(viewName);

        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
