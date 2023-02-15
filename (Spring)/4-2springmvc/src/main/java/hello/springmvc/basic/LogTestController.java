package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j //롬복이 제공하는 어노테이션이다
public class LogTestController {

    // org.slf4j.Logger를 import해야 한다.
//    private final Logger log = LoggerFactory.getLogger(getClass());
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);


    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        String name2 = "Spring2";
//        log.info("info log={}, {}", name, name2);


        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);


        return "ok"; //@RestController라서 논리뷰이름을 반환하는게 아니라, HTTP메시지 바디에 직접 넣을 내용을 반환한다.
        }

}
