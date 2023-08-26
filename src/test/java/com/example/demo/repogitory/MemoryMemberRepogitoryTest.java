package com.example.demo.repogitory;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.Test;

class MemoryMemberRepogitoryTest {

    MemoryMemberRepogitory repogitory;
    @Test
    public void save(){
        Member member = new Member();
        member.setName("SPRING");

    }
}
