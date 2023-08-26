package com.example.demo.repogitory;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepogitory {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
