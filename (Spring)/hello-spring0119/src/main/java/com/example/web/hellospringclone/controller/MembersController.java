package com.example.web.hellospringclone.controller;

import com.example.web.hellospringclone.domain.Member;
import com.example.web.hellospringclone.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersController {

    MemberService service;

    @Autowired
    public MembersController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public String newMember() {
        return "members/new";
    }

    @PostMapping("/new")
    public String createMember(String name) {
        Member member = new Member();
        member.setName(name);
        service.join(member);

        return "redirect:/";

    }

    @GetMapping("")
    public String memberList(Model model) {
        List<Member> members = service.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}