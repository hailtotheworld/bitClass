package com.example.web.service;

import com.example.web.domain.Member;
import com.example.web.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService memberService;

    MemoryMemberRepository memberRepository;

    //    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    //MemberService와 MemberServiceTest가 new한 MemoryMemberRepository 객체가 서로 다르다는점이 문제가 된다.
    //같은 repository로 테스트되어야 한다. (만약 MemoryMemberRepository에서 store에 static빼면 DB가 다른게 되잖아.)

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void join() {
        //given 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("hello");

        //when  이걸로 실행했을때
        Long saveId = memberService.join(member);

        //then  결과로 이게 나와야돼


        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void validateDuplicateMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThrows(이예외가터져야해, 이 로직을 실행할거야);
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        
        
//        try {
//            memberService.join(member2);
//            fail("예외가 발생해야합니다.");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }

        // then

    }

    @Test
    public void findMembers() {
    }

    @Test
    public void findOne() {
    }
}