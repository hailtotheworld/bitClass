package hello.login.web.filter;

import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            log.info("인증 체크 필터 시작{}", requestURI);

            // 화이트리스트가 아닌 url만 이 로직을 탄다
            if(isLoginCheckPath(requestURI)) {
                log.info("인증 체크 로직 실행{}", requestURI);
                HttpSession session = httpRequest.getSession(false);
                if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER)==null) {
                    log.info("미인증 사용자 요청{}", requestURI);

                    //로그인으로 redirect
                    httpResponse.sendRedirect("/login?redirectURL=" + requestURI); //로그인성공하면 전에 요청했던 페이지로 갈수있게끔.
                    return; //다음서블릿이나 컨트롤러 호출안하겠다는거다. sendRedirect호출되고 끝나는거지
                            //try내에서 return하더라도 finally블럭은 항상 호출된다.
                }
            }

            chain.doFilter(request,response);
            
        } catch (Exception e) {
            throw e; //예외 로깅 가능하지만, 톰캣까지 예외를 보내줘야 한다.
            // 여기서 예외를 먹어버리면 정상흐름이 되잖아. 그래서 WAS까지 예외를 올려줘야 한다.
        } finally {
            log.info("인증 체크 필터 종료 {} ", requestURI);
        }
    }

    /**
     * 화이트 리스트의 경우 인증 체크X
     */
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }


}
