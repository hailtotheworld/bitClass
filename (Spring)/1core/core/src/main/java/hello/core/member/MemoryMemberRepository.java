package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성이슈가 있어서 concurrenthashmap를 사용한다. 예제의 단순화를 위해서 그냥 hashmap썼음
    private  static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // map.put(key, value); <- key와 value를 넣어서 저장한다.
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // map.get(key);        -> key를 넣어서 그에 맞는 value를 반환한다.
    }
}
