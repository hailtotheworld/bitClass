package hello.coreClone.autowired;

import hello.coreClone.AutoAppConfig;
import hello.coreClone.discount.DiscountPolicy;
import hello.coreClone.member.Grade;
import hello.coreClone.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
    @Test
    void findAllBean() {
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"userA", Grade.VIP);

        int fixDiscountPrice = discountService.discountPrice(member,12000,"fixDiscountPolicy");
        Assertions.assertThat(fixDiscountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discountPrice(member,12000,"rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(1200);
    }

    static class DiscountService {
        private final Map<String,DiscountPolicy> discountPolicyMap;
        private final List<DiscountPolicy> discountPolicyList;

        public DiscountService(Map<String, DiscountPolicy> discountPolicyMap, List<DiscountPolicy> discountPolicyList) {
            this.discountPolicyMap = discountPolicyMap;
            this.discountPolicyList = discountPolicyList;
        }


        public int discountPrice(Member member, int price, String discountPolicyCode) {
            DiscountPolicy discountPolicy = discountPolicyMap.get(discountPolicyCode);
            int discountPrice = discountPolicy.discount(member, price);
            return discountPrice;
        }
    }

}
