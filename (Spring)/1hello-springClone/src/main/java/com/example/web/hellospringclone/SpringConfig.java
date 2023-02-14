package com.example.web.hellospringclone;

import com.example.web.hellospringclone.repository.*;
import com.example.web.hellospringclone.service.MemberService;
import com.example.web.hellospringclone.service.MemberServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private EntityManager em;

    private MemberRepository memberRepository;

    public SpringConfig(DataSource dataSource, JdbcTemplate jdbcTemplate, EntityManager em,MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService service() {
        return new MemberServiceImp(memberRepository);
    }

//    @Bean
//    public MemberRepository repository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }


}