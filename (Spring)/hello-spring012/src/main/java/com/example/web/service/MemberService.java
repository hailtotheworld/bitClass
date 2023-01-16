package com.example.web.service;

import com.example.web.domain.Member;
import com.example.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    // ctrl + shift + t 테스트바로만들어준다

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원 검증

//        result.get(); // 그냥 꺼내는거다
//        result.orElseGet(() -> ); // 값이 있으면 꺼내고, 값이 없으면 supplier

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 전체 회원 조회
    public List<String> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<String> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
