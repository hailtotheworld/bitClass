package com.example.web.hellospringclone.service;

import com.example.web.hellospringclone.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MemberServiceImp implements MemberService{

    private MemberRepository repository;

//    @Autowired
    public MemberServiceImp(MemberRepository repository) {
        this.repository = repository;
    }
}
