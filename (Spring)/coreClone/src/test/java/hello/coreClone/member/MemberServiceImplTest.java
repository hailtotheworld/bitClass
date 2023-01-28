package hello.coreClone.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Assertions.assertThat(member.getMemberId()).isEqualTo(1L);
    }

    @Test
    void findById() {
        Member member = new Member(1L,"memberA",Grade.BASIC);
        memberService.join(member);

        Assertions.assertThat(memberService.findById(1L)).isSameAs(member);
    }
}