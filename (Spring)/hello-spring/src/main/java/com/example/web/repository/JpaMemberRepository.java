package com.example.web.repository;

import com.example.web.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
public class JpaMemberRepository implements MemberRepository {

    //jpa는 EntityManager라는걸로 모든게 동작한다. 스프링부트가 현재데이터베이스랑 연결 다해서 자동으로 Entity매니저를 생성해준다.
    //EntityManager는 내부적으로 dataSource를 다 들고있어서 데이터베이스와 통신을 내부에서 다 처리한다.
    //jpa사용하려면 EntityManager을 주입받아야 한다. 우리는 그저 인젝션받아서 사용하면 된다.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    public List<Member> findAll() {
        //jpql이라는 객체지향쿼리를 써야한다.
        //테이블대상이 아니라 객체(Entity)를 대상으로 쿼리를 날리는거다. 그러면 이게 sql로 번역이 된다.
        return em.createQuery("select m from Member m", Member.class) //*을 사용하지않고, member엔티티자체를 select하는구나. 찾기만하면된다. 이미 매핑이 다 되어있다.
                .getResultList(); //select m from Member as m
    }
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
