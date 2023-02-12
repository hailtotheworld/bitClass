package com.example.web.controller;

import com.example.web.domain.Member;
import com.example.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members") // 끝에는 /가 없어야한다
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
//        System.out.println("memberService.getClass() = " + memberService.getClass()); //memberService.getClass() = class com.example.web.service.MemberService$$EnhancerBySpringCGLIB$$f584908b
    }

    @GetMapping("/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/new")
    public String create(String name) { //html로부터 받을값을 매개변수에 적어준다
        Member member = new Member();
        member.setName(name);

//      System.out.println("member.getName() = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }


//    @PostMapping("/new")
//    public String create(MemberForm form) {
//    //form.setName()에 html에서 받아온 name의 값을 넣어준다. private요소에는 접근못하지.
//        Member member = new Member();
//        member.setName(form.getName());
//
//        System.out.println("member.getName() = " + member.getName());
//
//        memberService.join(member);
//
//        return "redirect:/";
//    }


    @GetMapping("")
    public String list(Model model) { //html로 전달할model을 매개변수에 적어준다
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}

