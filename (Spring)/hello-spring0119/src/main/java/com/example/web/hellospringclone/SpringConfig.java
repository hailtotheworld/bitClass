package com.example.web.hellospringclone;

import com.example.web.hellospringclone.repository.MemberRepository;
import com.example.web.hellospringclone.repository.MemoryMemberRepository;
import com.example.web.hellospringclone.service.MemberService;
import com.example.web.hellospringclone.service.MemberServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService service() {
        return new MemberServiceImp(repository());
    }

    @Bean
    public MemberRepository repository() {
        return new MemoryMemberRepository();
    }

}
