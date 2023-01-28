package hello.coreClone.order;

import hello.coreClone.discount.DiscountPolicy;
import hello.coreClone.discount.FixDiscountPolicy;
import hello.coreClone.member.Grade;
import hello.coreClone.member.Member;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

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