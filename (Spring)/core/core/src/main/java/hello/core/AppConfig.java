package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemeryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 전체를 설정하고 구성한다.
@Configuration
public class AppConfig {

    // 생성자를 통해서 객체가 들어간다고해서, 생성자 주입이라고 한다
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } // return 구체적인객체주소반환(구체적인객체주소주입)

    @Bean
    public MemberRepository memberRepository() { //역할
        return new MemeryMemberRepository(); //구현
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
