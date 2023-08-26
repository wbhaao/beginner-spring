package com.example.demo.repogitory;

import com.example.demo.domain.Member;

class MemoryMemberRepogitoryTest {

    MemoryMemberRepogitory repogitory;
    @Test
    public void save(){
        Member member = new Member();
        member.setName("SPRING");

    }
}
