package com.example.eksamenbcknd2024.controller;

import com.amazonaws.services.iotjobsdataplane.model.ResourceNotFoundException;
import com.example.eksamenbcknd2024.model.Orders;
import com.example.eksamenbcknd2024.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable Long id) {
        return ordersRepository.findById(id);
    }

    @PostMapping("/create")
    public Orders createOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders orderDetails) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        order.setDate(orderDetails.getDate());
        order.setCustomer(orderDetails.getCustomer());

        return ordersRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersRepository.deleteById(id);
    }
}
