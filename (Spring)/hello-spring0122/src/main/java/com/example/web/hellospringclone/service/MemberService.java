package com.example.web.hellospringclone.service;

import com.example.web.hellospringclone.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Long join(Member member);

    List<Member> findMembers();

    Optional<Member> findOne(Long id);

    void validateDuplicateMember(Member member);

}
