package hello.login.web.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        //@SessionAttribute 다르게, 갖고오려는 세션저장소에 있는 name,객체를 몰라도 가져올수있구나.
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "세션이 없습니다";
        }

        // 세션 데이터 출력
        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}",session.getId());
        log.info("getMaxInactiveInterval={}",session.getMaxInactiveInterval()); //비활성화시키는 최대시간(초)
        log.info("getCreationTime={}",new Date(session.getCreationTime())); // long을 반환하니까 시각으로 바꿔준다.
        log.info("getLastAccessedTime={}",new Date(session.getLastAccessedTime()));
        log.info("isNew={}",session.isNew()); //처음에 생성할때만 true

        return "세션 출력";
    }
}
