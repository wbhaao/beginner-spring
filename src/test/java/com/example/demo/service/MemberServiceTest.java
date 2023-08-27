package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repogitory.MemoryMemberRepogitory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepogitory memberRepogitory;

    @BeforeEach
    public void beforeEach(){
        memberRepogitory = new MemoryMemberRepogitory();
        memberService = new MemberService(memberRepogitory);
    }

    @AfterEach
    public void afterEach(){
        memberRepogitory.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException exception) {
//            assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}