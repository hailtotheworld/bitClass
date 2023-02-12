package com.example.web;

import com.example.web.aop.TimeTraceAop;
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
    private MemberRepository memberRepository;
    // JpaRepository인터페이스를 상속받은 인터페이스가 구현체로 만들어져서 IoC컨테이너에 담겨있다.
    // 인터페이스가 구현체로 담겨있다니 신기하네.

    //    @Autowired //생성자가 1개일때 Autowired 생략해도 된다.
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
//        return  new MemberService(memberRepository());
        return  new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return  new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//        return null;
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

}
