package hello.coreClone.discount;

import hello.coreClone.member.Grade;
import hello.coreClone.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRate = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return price * 10 / 100;
        } else  {
            return price;
        }

    }
}
