package com.example.eksamenbcknd2024.controller;

import com.amazonaws.services.iotjobsdataplane.model.ResourceNotFoundException;
import com.example.eksamenbcknd2024.model.Item;
import com.example.eksamenbcknd2024.model.OrderItem;
import com.example.eksamenbcknd2024.model.Orders;
import com.example.eksamenbcknd2024.repository.ItemRepository;
import com.example.eksamenbcknd2024.repository.OrderItemRepository;
import com.example.eksamenbcknd2024.repository.OrdersRepository;
import com.example.eksamenbcknd2024.request.OrderItemCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/all")
    public Page<OrderItem> getAllOrderItems(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return orderItemRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemRepository.findById(id);
    }

    @PostMapping("/create")
    public OrderItem createOrderItem(@RequestBody OrderItemCreateRequest request) {
        // Fetch the Order entity by ID
        Orders order = ordersRepository.findById(request.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + request.getOrderId()));

        // Fetch the Item entity by ID
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + request.getItemId()));

        // Create the OrderItem entity and set the Order and Item
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setItem(item);

        // Save the OrderItem entity
        return orderItemRepository.save(orderItem);
    }


    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItemDetails) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + id));

        orderItem.setOrder(orderItemDetails.getOrder());
        orderItem.setItem(orderItemDetails.getItem());

        return orderItemRepository.save(orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemRepository.deleteById(id);
    }
}

