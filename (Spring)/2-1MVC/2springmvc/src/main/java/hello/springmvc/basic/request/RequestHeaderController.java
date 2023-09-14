package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod, // 어떤http메서드로 요청이왔는지 확인가능하다 (get,post..)
                          Locale locale, // 가장 우선순위가 높은 언어가 지정이된다. http요청메시지 헤더의 accept-language정보를 조회하는거네.
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host, //@RequestHeader("헤더의이름을매핑") String aaa(매개변수명은 아무거나적어도된다)
                          @CookieValue(value = "myCookie", required = false) String cookie//value는 쿠키이름이다. 찾는게 없으면 null로 들어온다
    ) {

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";

    }

}
