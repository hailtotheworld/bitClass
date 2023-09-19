package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @GetMapping("/")
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

        //쿠키가 있는 사용자-성공로직
        model.addAttribute("member",loginMember);
        return "loginHome";
    }

//    @GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model) {

        //세션 관리자에 저장된 회원 정보 조회
        Object member = (Member) sessionManager.getSession(request);

        //로그인
        if(member == null){
            return "home";
        }

        model.addAttribute("member",member);
        return "loginHome";
    }

//    @GetMapping("/")
    public String homeLoginV3(HttpServletRequest request, Model model) {

        //세션은 메모리를 쓰기 때문에 꼭 필요할 때만 써야한다.
        //처음들어온 사용자에게도 세션을 만들어줄 필요는 없잖아. 그러니까 매개변수에 false를 둔다
        HttpSession session = request.getSession(false);
        if(session == null) {
            return "home";
        }

        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        //세션에 회원 데이터가 없으면 home
        if(loginMember == null){
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }

    @GetMapping("/")
    public String homeLoginV3Spring(@SessionAttribute(name=SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home
        if(loginMember == null){
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }
}