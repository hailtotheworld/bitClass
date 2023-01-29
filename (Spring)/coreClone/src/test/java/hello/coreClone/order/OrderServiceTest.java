package hello.coreClone.order;

import hello.coreClone.AppConfig;
import hello.coreClone.discount.DiscountPolicy;
import hello.coreClone.discount.FixDiscountPolicy;
import hello.coreClone.member.Grade;
import hello.coreClone.member.Member;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    DiscountPolicy discountPolicy;


    @BeforeEach
    public void beforeEach() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        DiscountPolicy discountPolicy = ac.getBean("discountPolicy", DiscountPolicy.class);
        this.memberService = memberService;
        this.orderService = orderService;
        this.discountPolicy = discountPolicy;
    }

//    @BeforeEach
//    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
//        this.memberService = appConfig.memberService();
//        this.orderService = appConfig.orderService();
//        this.discountPolicy = appConfig.discountPolicy();
//
//    }

    @Test
    void createOrder() {
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        int price = 15000;
        int discountPrice = discountPolicy.discount(member, price);
        Order order = orderService.createOrder(member.getMemberId(), "itemA", price);

        Assertions.assertThat(order.getCalculatedPrice()).isEqualTo(14000);


        Member member2 = new Member(1L,"memberA", Grade.BASIC);
        memberService.join(member2);


        Order order2 = orderService.createOrder(member.getMemberId(), "itemA", price);

        Assertions.assertThat(order2.getCalculatedPrice()).isEqualTo(15000);


    }
}