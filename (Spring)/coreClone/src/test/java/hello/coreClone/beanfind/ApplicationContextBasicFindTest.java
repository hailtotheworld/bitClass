package hello.coreClone.beanfind;

import hello.coreClone.AppConfig;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /*
    beanDefinitionName = appConfig
    beanDefinitionName = discountPolicy
    beanDefinitionName = memberService
    beanDefinitionName = memberRepository
    beanDefinitionName = orderService
    */

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByBeanName() {
        Object memberService = ac.getBean("memberService");
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findByBeanType() {
        Object memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void findByBeanType2() {
        Object memberService = ac.getBean(MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findByBeanNameX() {
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
//        Assertions.assertThat(xxxxx).isInstanceOf(MemberServiceImpl.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxx", MemberService.class) );
    }





}
