package com.jpaShop.book.domain.item;

import com.jpaShop.book.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private int price; // 상품 가격
    private int stockQuantity; // 재고

    // == 비즈니스 로직 == //
    public void addStock(int stockQuantity){
        this.stockQuantity += stockQuantity;
    }

    public void removeStock(int stockQuantity){
        int restStock = this.stockQuantity - stockQuantity;
        if(restStock < 0){
            throw new NotEnoughStockException();
        }
        this.stockQuantity = restStock;
    }
}
