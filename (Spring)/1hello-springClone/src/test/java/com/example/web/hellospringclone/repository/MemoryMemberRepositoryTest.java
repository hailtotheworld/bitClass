package com.example.web.hellospringclone.repository;

import com.example.web.hellospringclone.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MemoryMemberRepositoryTest {

    MemberRepository store = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
//        store.clear();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring1");
        Member result = store.save(member);

        Assertions.assertThat(result.getName()).isEqualTo("spring1");

    }

    @Test
    void findById() {
        Member member = new Member();
        member.setName("spring1");
        Member result = store.save(member);

        Member member2 = new Member();
        member.setName("spring2");
        Member result2 = store.save(member2);

        Member result22 = store.findById(member2.getId()).get();


        Assertions.assertThat(result22).isEqualTo(result2);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        Member result1 = store.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        Member result2 = store.save(member2);

        Assertions.assertThat(member2).isEqualTo(store.findByName("spring2").get());
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        Member result1 = store.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        Member result2 = store.save(member2);

        List<Member> list = new ArrayList<>();

        list.add(result1);
        list.add(result2);

        Assertions.assertThat(store.findAll()).isEqualTo(list);

    }
}