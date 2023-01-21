package com.example.web;

import com.example.web.repository.JdbcMemberRepository;
import com.example.web.repository.JdbcTemplateMemberRepository;
import com.example.web.repository.MemberRepository;
import com.example.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 조립하는코드. 어셈블리.
@Configuration
public class SpringConfig {

    private DataSource dataSource;

//    @Autowired //생성자가 1개일때 Autowired 생략해도 된다.
    public SpringConfig(DataSource dataSource) { //설정파일에서 스프링이 만들어둔 dataSource의 bean을 주입받는거다.
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return  new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return  new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
