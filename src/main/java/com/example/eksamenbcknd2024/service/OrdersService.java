package com.example.eksamenbcknd2024.service;

import com.example.eksamenbcknd2024.model.Orders;
import com.example.eksamenbcknd2024.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository orderRepository;

    @Autowired
    public OrdersService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Orders saveOrder(Orders order) {
        // Add any business logic/validation here before saving
        return orderRepository.save(order);
    }

    public Orders updateOrder(Long id, Orders newOrder) {
        Optional<Orders> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Orders existingOrder = optionalOrder.get();
            existingOrder.setDate(newOrder.getDate());
            existingOrder.setCustomer(newOrder.getCustomer());
            // Add any other fields to update as needed
            return orderRepository.save(existingOrder);
        } else {
            // Handle order not found
            return null; // Or throw an exception
        }
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}

