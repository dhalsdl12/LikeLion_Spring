package com.jpaShop.book.service;

import com.jpaShop.book.domain.Member;
import com.jpaShop.book.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // db 기본 동작의 단위 (더이상 쪼개질 수 없는 단위로 동작해라.)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> members = memberRepository.findByName(member.getName());
        if(!members.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 하나의 회원 조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
