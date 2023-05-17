package com.jpaShop.book.service;

import com.jpaShop.book.domain.Member;
import com.jpaShop.book.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        Member member = new Member();
        member.setName("Kwon");

        Long saveId = memberService.join(member);
        Assertions.assertThat(memberService.findOne(saveId)).isEqualTo(member);
    }

    @Test
    public void 중복_회원_예외(){
        Member member = new Member();
        member.setName("Kwon");
        Member member1 = new Member();
        member1.setName("Kwon");

        memberService.join(member);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member1));
    }
}