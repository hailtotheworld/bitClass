package com.example.web.domain;

import javax.persistence.*;

@Entity //JPA가 관리하는 entity가 되는거다
public class Member {

    @Id //pk를 매핑해준다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에서 값을 알아서 생성해주고 있는걸 IDENTITY전략이라고 한다.
    private Long id; // Long은 wrapper클래스다

//    @Column(name = "username")
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
