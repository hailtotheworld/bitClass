package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//org.springframework.web.servlet.mvc.Controller; //옛날에 사용하던 인터페이스타입
//org.springframework.stereotype.Controller; //어노테이션타입

@Component("/springmvc/old-controller") // 스프링빈의 이름이다. 스프링빈의 이름을 url패턴으로 맞춘거다
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
