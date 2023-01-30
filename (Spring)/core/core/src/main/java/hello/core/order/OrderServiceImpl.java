package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemeryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // final은 무조건 값이 할당되어야 한다. 한번 할당된 값을 변경할 수 없다.
    // 주입받을객체주소만있고주입되는주소값은없는데 final이 있으면 무조건 생성자를 통해서 할당이 되어야 한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
