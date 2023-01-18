package com.example.web;

import com.example.web.repository.MemberRepository;
import com.example.web.repository.MemoryMemberRepository;
import com.example.web.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return  new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return  new MemoryMemberRepository();
    }

}
