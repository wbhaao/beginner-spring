package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repogitory.MemberRepogitory;
import com.example.demo.repogitory.MemoryMemberRepogitory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {
    private final MemberRepogitory memberRepogitory;

    public MemberService(MemberRepogitory memberRepogitory){
        this.memberRepogitory = memberRepogitory;
    }
    /*
    * 회원 가입
    * */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원은 안됨
        validateDuplicateMember(member);

        memberRepogitory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepogitory.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepogitory.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepogitory.findById(memberId);
    }
}
