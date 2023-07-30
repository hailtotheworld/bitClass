package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    // 반환타입이 없으면서 이렇게 응답에 값을 직접 집어넣으면, view조회하지 않는다.
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age= {}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge //자동으로 형변환해준다
    ) {

        log.info("username = {}, age= {}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, //파라미터의 변수명와 같으면 ("파라미터명") 생략가능하다
            @RequestParam int age
    ) {

        log.info("username = {}, age= {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        //String,int,Integer..등 단순타입이고, 파라미터의 변수명과 같으면 @RequestParam도 생략가능하다.
        //이렇게 애노테이션을 완전히 생략해도 되는데, 너무 없는 것도 약간 과하다는 주관적 생각이 있다.
        //@RequestParam 이 있으면 명확하게 요청 파리미터에서 데이터를 읽는다는 것을 알 수 있다.

        log.info("username = {}, age= {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //required = true가 기본값이다. 값이 전달안되면 400에러를 낸다
            // 주의! - 파라미터 이름만 사용
            // /request-param?username=
            // 파라미터 이름만 있고 값이 없는 경우 빈문자로 통과 (null이 아니라 빈문자라는 값이 들어온걸로 인식하는구나)

            @RequestParam(required = false) Integer age //required=false면 값이 없으면 null이 오기때문에 int가 아닌 Integer로 받아야 한다
    ) {
        log.info("username = {}, age= {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            // 사실 defaultValue가 들어오면 required가 있든없든상관없다. 값이 있으면 들어오고, 없으면 기본값이 들어오기때문이다.
            @RequestParam(required = true, defaultValue = "guest") String username, //값이안들어오면 defaultValue의 값으로 정해진다
            // 만약 ?age= 이렇게 빈문자로 하면 defaultValue가 들어온다. 빈문자까지 defaultValue로 처리해준다
            @RequestParam(required = false, defaultValue = "-1") int age
    ) {
        log.info("username = {}, age= {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age= {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-multimap")
    public String requestParamMultimap(@RequestParam MultiValueMap<String, Object> paramMap) {
        log.info("username = {}, age= {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username, @RequestParam int age){
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username = {}, age= {}", helloData.getUsername(), helloData.getAge());
//        log.info("helloData={}",helloData);
//
//        return "ok";
//    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute() HelloData helloData) { //마치 마법처럼 HelloData 객체가 생성되고, 요청 파라미터의 값도 모두 들어가 있다.
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);

        log.info("username = {}, age= {}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {

        log.info("username = {}, age= {}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }


}
