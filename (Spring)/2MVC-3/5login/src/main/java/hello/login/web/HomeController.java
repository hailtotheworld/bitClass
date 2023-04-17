package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String homeLogin(@CookieValue(name= "memberId", required = false) Long memberId, Model model) {
        // 쿠키를 꺼낼때 HttpServletRequest로 꺼내도 되지만, 스프링에서 제공하는 @CookieValue로 꺼내도 된다.
        // 쿠키의 값은 String이지만 스프링이 타입컨버팅을 해줘서 Long으로 꺼내써도 된다
        // 쿠키가없는 사용자도 들어오기 때문에 required속성은 false로 해줘야 한다.

        //쿠키가 없는 사용자
        if(memberId == null) {
            return "home";
        }
        
        //쿠키가 있는 사용자
        Member loginMember = memberRepository.findById(memberId);
        if(loginMember == null){ // 쿠키가 너무 옛날에 만들어졌거나해서 DB에 없을수도 있다.
            return "home";
        }

        //쿠키가 있는 사용자 성공로직
        model.addAttribute("member",loginMember);
        return "loginHome";

    }
}