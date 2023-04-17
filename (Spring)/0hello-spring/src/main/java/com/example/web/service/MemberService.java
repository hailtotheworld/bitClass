package com.example.web.service;

import com.example.web.domain.Member;
import com.example.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    // ctrl + shift + t 테스트바로만들어준다

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
//        System.out.println("memberRepository.getClass() = " + memberRepository.getClass()); //memberRepository.getClass() = class com.sun.proxy.$Proxy105
    }

    // 회원가입
    public Long join(Member member) {

//        long start = System.currentTimeMillis();
//        try {
            validateDuplicateMember(member); // 중복회원 검증
            memberRepository.save(member);
            return member.getId();
//        } finally { //예외가 터져도 finally구문은 항상 실행된다.
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join = " + timeMs + "ms");
//        }


//        result.get(); // 그냥 꺼내는거다
//        result.orElseGet(() -> ); // 값이 있으면 꺼내고, 값이 없으면 supplier

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
