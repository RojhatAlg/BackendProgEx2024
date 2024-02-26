package com.example.eksamenbcknd2024.model;

import com.example.eksamenbcknd2024.repository.CustomerRepository;
import com.example.eksamenbcknd2024.repository.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderTests {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateOrder() {
        Customer customer = new Customer();
        customer.setName("John Cena");
        customer.setEmail("john@example.com");
        customer = customerRepository.save(customer);

        Orders order = new Orders();
        order.setDate(LocalDate.now());
        order.setCustomer(customer);
        order = ordersRepository.save(order);

        assertNotNull(order.getOrderId());
        assertNotNull(order.getDate());
        assertEquals(customer, order.getCustomer());
    }

    @Test
    public void testRetrieveOrder() {
        Customer customer = new Customer();
        customer.setName("Jane Smith");
        customer.setEmail("jane@example.com");
        customer = customerRepository.save(customer);

        Orders order = new Orders();
        order.setDate(LocalDate.now());
        order.setCustomer(customer);
        order = ordersRepository.save(order);

        Long orderId = order.getOrderId();

        Orders retrievedOrder = ordersRepository.findById(orderId).orElse(null);
        assertNotNull(retrievedOrder);
        assertEquals(order.getDate(), retrievedOrder.getDate());
        assertEquals(order.getCustomer(), retrievedOrder.getCustomer());
    }

}
