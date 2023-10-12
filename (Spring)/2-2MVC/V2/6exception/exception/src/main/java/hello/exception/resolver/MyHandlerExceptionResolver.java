package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); // Exception을 sendError로 바꿔치기한 거다.
                return new ModelAndView();
                // return new ModelAndView(); 빈 값으로 넘기면, 정상흐름으로 진행된다.

                // return new ModelAndView(ModelAndView 지정); ModelAndView 에 View , Model 등의 정보를 지정해서 반환하면 뷰를 렌더링 한다.

                // return null;  null 을 반환하면, 다음 ExceptionResolver 를 찾아서 실행한다.
                  // 만약 처리할 수 있는 ExceptionResolver 가 없으면 예외 처리가 안되고, 기존에 발생한 예외를 서블릿 밖으로 던진다.
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
        }

        return null;
    }

}
