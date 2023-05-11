package jpa.test.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @OneToOne
    @JoinColumn(name = "DETAIL_ID")
    private OrderDetails details;
}
