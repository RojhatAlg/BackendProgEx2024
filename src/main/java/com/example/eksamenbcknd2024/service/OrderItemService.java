package com.example.eksamenbcknd2024.service;

import com.example.eksamenbcknd2024.model.OrderItem;
import com.example.eksamenbcknd2024.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        // Add any business logic/validation here before saving
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem newOrderItem) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
        if (optionalOrderItem.isPresent()) {
            OrderItem existingOrderItem = optionalOrderItem.get();
            existingOrderItem.setOrder(newOrderItem.getOrder());
            existingOrderItem.setItem(newOrderItem.getItem());
            // Add any other fields to update as needed
            return orderItemRepository.save(existingOrderItem);
        } else {
            // Handle order item not found
            return null; // Or throw an exception
        }
    }

    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteById(id);
    }
}

