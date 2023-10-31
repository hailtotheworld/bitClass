package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV010", 10000);
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        assertThat(findMember).isEqualTo(member);

        //update: money 10000 -> 20000
        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(member.getMemberId());
        assertThatThrownBy(() -> repository.findById(member.getMemberId())).isInstanceOf(NoSuchElementException.class);
    }



    @Test
    void deleteAll() throws SQLException {
        Member member1 = new Member("memberV011", 10000);
        Member member2 = new Member("memberV012", 10000);
        Member member3 = new Member("memberV013", 10000);
        repository.save(member1);
        repository.save(member2);
        repository.save(member3);
        repository.deleteAll();

        assertThatThrownBy(() -> repository.findById("memberV011")).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> repository.findById("memberV012")).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> repository.findById("memberV013")).isInstanceOf(NoSuchElementException.class);
    }
}