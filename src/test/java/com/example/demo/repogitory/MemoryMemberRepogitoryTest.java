package com.example.demo.repogitory;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepogitoryTest {
    MemoryMemberRepogitory repogitory = new MemoryMemberRepogitory();

    @AfterEach
    public void afterEach() {
        repogitory.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("SPRING");

        repogitory.save(member);

        Member result = repogitory.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repogitory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repogitory.save(member2);

        Member result = repogitory.findByName("spring2").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repogitory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repogitory.save(member2);

        List<Member> result = repogitory.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
