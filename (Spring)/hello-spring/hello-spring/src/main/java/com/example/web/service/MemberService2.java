package com.example.web.service;

import com.example.web.domain.Member;
import com.example.web.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService2 {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService2(MemberRepository memberRepository) {
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
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
