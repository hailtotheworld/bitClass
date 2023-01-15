package com.example.web.repository;

import com.example.web.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); //name은 고객이 회원가입할때 적는이름이다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null이 반환될 가능성이 있으면 Optional의 .ofNullable()메서드로 감싼다. 이렇게 null이어도 감쌀수다.
        // 이렇게 감싸서 반환을해주면 클라이언트에서 뭘 할 수가 있다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //끝까지 돌렸는데 없으면 Optional에 null이 포함되서 반환된다
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
