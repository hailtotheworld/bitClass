package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.kerberos.KerberosTicket;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
@Controller //@Controller가 클래스레벨에 붙어 있는 경우에 각 메서드들을 매핑 정보로 인식한다.
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        responseWriter.write("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity)  {
//    public HttpEntity<String> requestBodyStringV3(RequestEntity<String> httpEntity)  {
        // 너는 문자구나. 그럼 내가 http바디에 있는걸 문자로 바꿔서 너한테 넣어줄게. http메시지컨버터가 동작한다
        String messageBody = httpEntity.getBody(); //http메시지에있는 바디를 꺼내는거다

        log.info("messageBody={}", messageBody);

        return new HttpEntity<>("ok"); //마치 http메시지를 그대로 주고받는 형식으로 만들수있다
//        return new ResponseEntity<>("ok",HttpStatus.CREATED); //마치 http메시지를 그대로 주고받는 형식으로 만들수있다
    }


    @ResponseBody //http메시지바디에 바로 응답나가는거다
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody, @RequestHeader Map<String,Object> headers) { //http메시지바디 읽어서 변수에 넣어주는거다.

        log.info("messageBody={}", messageBody);
        log.info("header={}", headers);

        headers.forEach((key, value) -> System.out.println(key + ":" + value));

        return "ok";
    }
}
