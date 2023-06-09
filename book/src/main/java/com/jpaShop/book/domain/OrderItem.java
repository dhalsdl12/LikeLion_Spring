package com.jpaShop.book.domain;

import com.jpaShop.book.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private int orderPrice; // 주문 당시 가격
    private int count; // 주문 수량

    public void cancel() {
        getItem().addStock(count);
    }
}
