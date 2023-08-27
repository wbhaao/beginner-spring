package com.example.demo;

import com.example.demo.repogitory.MemberRepogitory;
import com.example.demo.repogitory.MemoryMemberRepogitory;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepogitory());
    }

    @Bean
    public MemberRepogitory memberRepogitory(){
        return new MemoryMemberRepogitory();
    }
}
