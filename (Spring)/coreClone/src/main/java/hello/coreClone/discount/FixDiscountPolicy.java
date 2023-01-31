package hello.coreClone.discount;

import hello.coreClone.member.Grade;
import hello.coreClone.member.Member;
import hello.coreClone.member.MemberService;
import hello.coreClone.member.MemberServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountPrice = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP){
            return discountPrice = 1000;
        } else {
            return discountPrice = 0;
        }
    }
}
