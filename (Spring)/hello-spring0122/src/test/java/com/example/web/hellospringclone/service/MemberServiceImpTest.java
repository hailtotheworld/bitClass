package com.example.web.hellospringclone.service;

import com.example.web.hellospringclone.domain.Member;
import com.example.web.hellospringclone.repository.MemberRepository;
import com.example.web.hellospringclone.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImpTest {

    MemberRepository repository;
    MemberService service;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberServiceImp(repository);
    }

    @AfterEach
    public void afterEach() {
        service.clearList();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");
        service.join(member);

    }

    @Test
    void validateDuplicateMember() {
        Member member1 = new Member();
        member1.setName("spring");
        service.join(member1);


        Member member2 = new Member();
        member2.setName("spring");


        Assertions.assertThrows(IllegalStateException.class, () -> service.join(member2));


    }


    @Test
    void findMembers() {


    }

    @Test
    void findOne() {
    }
}