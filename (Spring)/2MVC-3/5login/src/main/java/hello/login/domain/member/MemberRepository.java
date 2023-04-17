package hello.login.domain.member;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용

    public Member save(Member member) {
        member.setId(sequence++);
        log.info("save: member={}",member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
/*        List<Member> all = findAll();
        for (Member m : all) {
            if(m.getLoginId().equals(loginId)) {
                return Optional.of(m);
                // Optional.of(지금여기들어가는게) null일수가 없구나
                // List가 비어있었다면 for문이 실행되지 않았을거고, 찾는게 없었다면 if문으로 들어오지 않았을테니까.
            }
        }
        return Optional.empty();*/

        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
