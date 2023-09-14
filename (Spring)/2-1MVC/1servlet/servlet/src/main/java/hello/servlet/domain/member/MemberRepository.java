package hello.servlet.domain.member;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려해야한다.
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 싱글톤이기 때문에 static없어도 하나만 있는게 보장이된다. static그냥써둠.
    private static long sequence = 0L;  // 싱글톤이기 때문에 static없어도 하나만 있는게 보장이된다. static그냥써둠.

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
