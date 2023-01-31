package hello.coreClone.order;

import hello.coreClone.discount.DiscountPolicy;
import hello.coreClone.member.Member;
import hello.coreClone.member.MemberService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//    MemberService memberService = new MemberServiceImpl();
//    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private final MemberService memberService;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy) {
        this.memberService = memberService;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberService.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice,itemPrice-discountPrice);
    }
}
