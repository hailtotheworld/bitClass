package com.example.web;

import com.example.web.repository.JpaMemberRepository;
import com.example.web.repository.MemberRepository;
import com.example.web.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// 조립하는코드. 어셈블리.
@Configuration
public class SpringConfig {

    private DataSource dataSource;
    private EntityManager em;

    //    @Autowired //생성자가 1개일때 Autowired 생략해도 된다.
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }


    @Bean
    public MemberService memberService() {
        return  new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return  new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
