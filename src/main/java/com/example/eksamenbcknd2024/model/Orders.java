package com.example.eksamenbcknd2024.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Orders() {
    }

    public Orders(Long orderId, LocalDate date, Customer customer) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
