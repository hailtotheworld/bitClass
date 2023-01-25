package com.example.web.hellospringclone.repository;

import com.example.web.hellospringclone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // MemberRepository의 Bean이 IoC컨테이너에 담기게 된다. 인터페이스인데 담기네. 신기하지.

    Optional<Member> findByName(String name);
}
