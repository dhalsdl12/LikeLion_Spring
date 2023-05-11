package jpa.test.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String memberName;
    private String address;
    @OneToMany
    @ElementCollection
    @CollectionTable(
            name = "ORDERLIST",
            joinColumns = @JoinColumn(name = "ORDER_ID")
    )
    private List<Orders> orderList = new ArrayList<>();
}
