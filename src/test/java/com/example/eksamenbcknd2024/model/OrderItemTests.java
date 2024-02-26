package com.example.eksamenbcknd2024.model;

import com.example.eksamenbcknd2024.repository.ItemRepository;
import com.example.eksamenbcknd2024.repository.OrderItemRepository;
import com.example.eksamenbcknd2024.repository.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderItemTests {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCreateOrderItem() {
        Orders order = new Orders();
        order.setDate(LocalDate.now());
        order = ordersRepository.save(order);

        Item item = new Item();
        item.setName("Desk");
        item.setPrice(BigDecimal.valueOf(39.99));
        item.setProductId("DSK002");
        item = itemRepository.save(item);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem = orderItemRepository.save(orderItem);

        assertNotNull(orderItem.getId());
        assertEquals(order, orderItem.getOrder());
        assertEquals(item, orderItem.getItem());
    }

}
