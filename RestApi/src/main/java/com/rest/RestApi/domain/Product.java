package com.rest.RestApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private Long price;

    public Product(String productName, Long price) {
        this.productName = productName;
        this.price = price;
    }

    public Product() {
    }
}
