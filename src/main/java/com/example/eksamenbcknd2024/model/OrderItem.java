package com.example.eksamenbcknd2024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    public OrderItem() {
    }

    public OrderItem(Long id, Orders order, Item item) {
        this.id = id;
        this.order = order;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
