package com.jpaShop.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member") // 상대 객체에서 이 객체를 참조할 때 작성한 필드명
    private List<Order> orders = new ArrayList<>();
}
