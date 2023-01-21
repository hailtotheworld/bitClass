package com.example.web.hellospringclone.service;

import com.example.web.hellospringclone.domain.Member;
import com.example.web.hellospringclone.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberServiceImp implements MemberService{

    private MemberRepository repository;

//    @Autowired
    public MemberServiceImp(MemberRepository repository) {
        this.repository = repository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);

        repository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return repository.findById(id);
    }

    public void validateDuplicateMember(Member member) {
        repository.findByName(member.getName()).ifPresent(member1 -> {throw new IllegalStateException();});
    }

    public void clearList() {
        repository.clear();
    }
}
