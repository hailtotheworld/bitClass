package com.example.web.hellospringclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data","안녕 스프링~!");
        return "index";
    }

    @GetMapping("helloTemplate")
    public String helloTemplate(Model model, @RequestParam(required = false, name = "name") String name) {
        model.addAttribute("name","안녕 스프링~!");
        return "helloTemplate";
    }

    @ResponseBody
    @GetMapping("apiString")
    public String apiString() {
        return "문자열 그대로 반환";
    }

    @ResponseBody
    @GetMapping("apiJson")
    public Member apiJson() {
        Member member = new Member();
        member.setMemId(1);
        member.setMemName("첫이름");
        return member;
    }

    class Member {
        private int memId;
        private String memName;

        public Member() {
        }

        public Member(int memId, String memName) {
            this.memId = memId;
            this.memName = memName;
        }

        public int getMemId() {
            return memId;
        }

        public void setMemId(int memId) {
            this.memId = memId;
        }

        public String getMemName() {
            return memName;
        }

        public void setMemName(String memName) {
            this.memName = memName;
        }
    }
}
