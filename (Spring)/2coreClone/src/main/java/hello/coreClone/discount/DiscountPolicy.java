package hello.coreClone.discount;

import hello.coreClone.member.Member;

public interface DiscountPolicy {

    int discount(Member member,int price);
}
