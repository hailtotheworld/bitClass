package com.example.web.repository;

import com.example.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,MemberRepository {
    //인터페이스가 인터페이스를 받을때는 extends라고 한다, 인터페이스는 다중상속이 된다.

    //JpaRepository(인터페이스)를 받고 있는 인터페이스는 스프링데이터Jpa가 프록시라는 기술을 이용해서 자동으로 구현체를 만들어서, 스프링빈에 자동으로 등록한다.
//공통할수있는 CRUD는 이미 다 JpaRepository에 만들어져 있다.

    // 비즈니스가 달라 공통화할수없는건 직접 적어준다.
    // JPQL select m from Member m where m.name = ?
    // 메서드이름에 규칙이있다. 메서드이름만 잘 적어주면, 인터페이스만으로 개발이 끝난다. 단순한게80% 복잡한게20% 쯤 되는데 단순한80%가 인터페이스만으로 끝나는거다.
    @Override
    Optional<Member> findByName(String name);
//    Optional<Member> findByNameAndId(String name,Long id);
}
