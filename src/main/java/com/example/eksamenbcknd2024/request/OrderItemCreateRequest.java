package com.example.eksamenbcknd2024.request;

public class OrderItemCreateRequest {
    private Long orderId;
    private Long itemId;

    // Constructors
    public OrderItemCreateRequest() {
    }

    public OrderItemCreateRequest(Long orderId, Long itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}

