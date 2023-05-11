package jpa.test.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETAIL_ID")
    private Long id;
    private int quantity;
    private String color;
}
