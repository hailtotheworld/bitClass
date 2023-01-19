package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data", "인덱스페이지입니다");
        return "index";
    }

    @GetMapping("hello")
    public String hello(Model model, @RequestParam(required = false, name = "name") String value) {
        model.addAttribute("name", value);
        // (키,값) 뷰에서는 키를이용해서 값을꺼낸다
        // ?key=value
        return "hello"; //  /resources/templates/  hello  .html
    }

    @GetMapping("api-string")
    @ResponseBody
    public String apiString(Model model, @RequestParam(required = false, name = "name") String value) {
        return "api-string " + value; //이렇게 문자열을 데이터로 주는 방식은 거의 안쓴다.
    }

    @GetMapping("api")
    @ResponseBody
    public List<Notice> api(Model model) { // 반환형식 자체가 객체다
        Notice notice1 = new Notice();
        notice1.setName("나의이름은");
        notice1.setScore(98);

        Notice notice2 = new Notice();
        notice2.setName("이름2");
        notice2.setScore(22);

        List<Notice> list = new ArrayList<Notice>();
        list.add(notice1);
        list.add(notice2);

        return list;
    }

    private class Notice { // 내부클래스는 외부클래스를 제외하고 다른 클래스에서 잘 사용되지 않는 것이어야 한다.
        private String name;
        private int score;

        public Notice() {
        }

        public Notice(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }
}
