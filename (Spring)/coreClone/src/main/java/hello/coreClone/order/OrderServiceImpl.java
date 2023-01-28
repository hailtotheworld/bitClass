package hello.coreClone.order;

import hello.coreClone.discount.DiscountPolicy;
import hello.coreClone.discount.FixDiscountPolicy;
import hello.coreClone.member.Member;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService{

    MemberService memberService = new MemberServiceImpl();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberService.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice,itemPrice-discountPrice);
    }
}
