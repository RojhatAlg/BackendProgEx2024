package com.example.eksamenbcknd2024.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    private BigDecimal price;

    private String productId;

    public Item() {
    }

    public Item(Long itemId, String name, BigDecimal price, String productId) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
