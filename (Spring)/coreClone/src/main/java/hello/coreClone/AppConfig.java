package hello.coreClone;

import hello.coreClone.discount.DiscountPolicy;
import hello.coreClone.discount.FixDiscountPolicy;
import hello.coreClone.member.MemberRepository;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;
import hello.coreClone.member.MemoryMemberRepository;
import hello.coreClone.order.Order;
import hello.coreClone.order.OrderService;
import hello.coreClone.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberService(),discountPolicy());
    }
}
