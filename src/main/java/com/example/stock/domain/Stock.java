package com.example.stock.domain;

import jakarta.persistence.*;

@Entity
public class Stock {

    // id, productId, quantity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    // 옵티미스틱 락을 사용하기 위해선 version 어노테이션을 사용해야함
    @Version
    private Long version;

    public Stock() {

    }

    public Stock(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void decress(Long quantity) {
        if(this.quantity - quantity < 0) throw new RuntimeException("foo");

        this.quantity = this.quantity - quantity;
    }
}
