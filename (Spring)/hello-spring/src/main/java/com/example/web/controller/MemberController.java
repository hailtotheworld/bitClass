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
    }

    @GetMapping("/new")
    public String createForm() {
        return "members/createMemberForm";
    }

//    @PostMapping("/new")
//    public String create(MemberForm form) {
//        Member member = new Member();
//        member.setName(form.getName());
//
//        System.out.println("member.getName() = " + member.getName());
//
//        memberService.join(member);
//
//        return "redirect:/";
//    }

    @PostMapping("/new")
    public String create(String name) {
        Member member = new Member();
        member.setName(name);

        System.out.println("member.getName() = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}

