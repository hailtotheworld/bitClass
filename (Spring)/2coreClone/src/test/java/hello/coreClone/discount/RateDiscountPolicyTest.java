package hello.coreClone.discount;

import hello.coreClone.AppConfig;
import hello.coreClone.member.Grade;
import hello.coreClone.member.Member;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;
import hello.coreClone.order.Order;
import hello.coreClone.order.OrderService;
import hello.coreClone.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    MemberService memberService;
    DiscountPolicy discountPolicy;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.discountPolicy = appConfig.discountPolicy();
        this.orderService = appConfig.orderService();
    }

    @Test
    void discount() {
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(1L, "itemA", 27000);

        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(2700);
        Assertions.assertThat(itemA.getCalculatedPrice()).isEqualTo(27000-2700);
    }
}