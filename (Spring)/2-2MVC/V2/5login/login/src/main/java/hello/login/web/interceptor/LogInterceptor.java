package hello.login.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID, uuid);
        // preHandle에서 request 객체에 값을 담으면 postHandle, afterCompletion 그 값을 꺼내 쓸 수있다.
        // request 객체의 생명주기가 그러하기 때문이다.

        //@RequestMapping을 사용하는 경우에는 HandlerMethod 가 넘어온다.
        //정적 리소스를 사용하는 경우에는 ResourceHttpRequestHandler 가 사용 된다.
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;//호출할 컨트롤러 메서드의 모든 정보가 포함되어 있다.
        }


        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);

        return true; // true 호출해야지 핸들러 어댑터가 호출되고, Object handler 가 호출되는 거다.
//        return false; // false로 하면 다음 진행이 되지 않는다.

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String logId = (String) request.getAttribute(LOG_ID);
        log.info("RESPONSE [{}][{}][{}]", logId, requestURI, handler);

        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }

    }
}
