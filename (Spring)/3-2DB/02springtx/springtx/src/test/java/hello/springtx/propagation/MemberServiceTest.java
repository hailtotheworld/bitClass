package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LogRepository logRepository;

    /**
     * memberService      @Transactional: OFF
     * memberRepository   @Transactional: ON
     * logRepository      @Transactional: ON
     */
    @Test
    void outerTxOff_success() {
        //given
        String username = "outerTxoff_success";

        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService      @Transactional: OFF
     * memberRepository   @Transactional: ON
     * logRepository      @Transactional: ON Exception
     */
    @Test
    void outerTxOff_fail() {
        //given
        String username = "로그예외_outerTxoff_fail";

        //when
        assertThatThrownBy(() -> memberService.joinV1(username)).isInstanceOf(RuntimeException.class);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(memberRepository.find(username).isEmpty());
    }
////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * memberService      @Transactional: ON
     * memberRepository   @Transactional: OFF
     * logRepository      @Transactional: OFF
     */
    @Test
    void singleTx() {
        //given
        String username = "outerTxoff_success";

        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService      @Transactional: ON
     * memberRepository   @Transactional: ON
     * logRepository      @Transactional: ON
     */
    //모든 데이터 커밋
    @Test
    void outerTxOn_success() {
        //given
        String username = "outerTxOn_success";

        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService      @Transactional: ON
     * memberRepository   @Transactional: ON
     * logRepository      @Transactional: ON Exception
     */
    //모든 데이터가 롤백된다.
    @Test
    void outerTxOn_fail() {
        //given
        String username = "로그예외_outerTxOn_fail";

        //when
        assertThatThrownBy(() -> memberService.joinV1(username)).isInstanceOf(RuntimeException.class);

        //then
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService      @Transactional: ON
     * memberRepository   @Transactional: ON
     * logRepository      @Transactional: ON Exception
     */
    // 모두 롤백
    @Test
    void recoverException_fail() {
        //given
        String username = "로그예외_recoverException_fail";

        //when
        assertThatThrownBy(() -> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);
        //isNew트랜잭션에서 예외를 잡아서 처리한다한들, isNotNew트랜잭션에서 예외가 터지면 rollback-only가 마킹되기때문에, isNew트랜잭션도 롤백된다.

        //then
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService      @Transactional: ON
     * memberRepository   @Transactional: ON
     * logRepository      @Transactional: ON(REQUIRES_NEW) Exception
     */
    @Test
    void recoverException_success() {
        //given
        String username = "로그예외_recoverException_success";

        //when
        memberService.joinV2(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

}