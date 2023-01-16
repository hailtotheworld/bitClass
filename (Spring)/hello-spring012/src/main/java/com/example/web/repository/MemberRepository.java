package com.example.web.repository;

import com.example.web.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

//    Optional<String> findById(Long id);
//    Optional<String> findByName(String name);

    List<String> findAll();

}
