package hello.coreClone.member;

import hello.coreClone.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {



    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        this.memberService = memberService;
    }

//    @BeforeEach
//    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
//        this.memberService = appConfig.memberService();
//    }

    @Test
    void join() {
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Assertions.assertThat(member.getMemberId()).isEqualTo(1L);
    }

    @Test
    void findById() {
        Member member = new Member(1L,"memberA",Grade.BASIC);
        memberService.join(member);

        Assertions.assertThat(memberService.findById(1L)).isSameAs(member);
    }
}