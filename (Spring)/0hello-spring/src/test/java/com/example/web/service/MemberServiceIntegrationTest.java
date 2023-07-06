package com.example.web.service;

import com.example.web.domain.Member;
import com.example.web.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
<통합Integration테스트> <통합테스트>
-----------------------------------------------------------------------------------------------------------------
@SpringBootTest
-스프링까지 다 올리고, DB까지 다 연결해서 동작하는 통합테스트.
-DB연결하면 데이터베이스 커넥션정보를 스프링이 들고 있으니까, 순수한 자바코드로하는 테스트는 할 수 없다.
--------------------------------------------------------
@Transactional
-테스트를 실행할때 트랜잭션을 실행하고, DB에 테스트를 다하고나서, rollback을 해준다.
 (데이터베이스는 기본적으로 트랜잭션이라는 개념이 있다. 데이터수정을하고 commit을해줘야 반영을 한다.)
-테스트를 반복해서 실행할 수 있다. 다음 테스트에 영향을 주지 않는다.
 (테스트 끝나고나서 데이터 지우는 번잡한짓을 안해도 된다.)
-테스트 메서드 마다 일일이 동작한다
eg) 트랜잭션-테스트메서드실행-rollback,트랜잭션-테스트메서드실행-rollback....

-테스트에서 실제 commit하기를 원하면 commit을 원하는 메서드에 @Commit을 적어주면 된다.
--------------------------------------------------------
-테스트는 제일 끝단에 있는거라서 테스트코드만들때는 제일 편한방법으로 DI하면 된다.
 테스트를 다른데서 갖다 쓸게 아니잖아. 내가 필요한거 인젝션해서 쓰고 끝이잖아.
 필드주입을 이용해서 DI해도 된다.
-----------------------------------------------------------------------------------------------------------------
 */

@SpringBootTest //스프링빈들을 이용할 수 있게되는구나
@Transactional //테스트끝난다음에 커밋하지 않고, 롤백한다.
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

//    @Autowired
//    MemberRepository memberRepository;


    /*
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    */ //@SpringBootTest니까 알아서 스프링빈에 넣어져있다.

    /*
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    */ // @Transactional

    @Test
    public void join() {
        //given 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("spring12");

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