package com.example.eksamenbcknd2024.model;

import com.example.eksamenbcknd2024.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // This annotation will configure an in-memory database and set up Spring Data JPA repositories
public class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        // Test creating a new customer and saving it to the database
        Customer customer = new Customer();
        customer.setName("Jalen Brown");
        customer.setEmail("jb@example.com");

        // Save the customer to the database
        customer = customerRepository.save(customer);

        assertNotNull(customer.getCustomerId());
        assertEquals("Jalen Brown", customer.getName());
        assertEquals("jb@example.com", customer.getEmail());
    }

    @Test
    public void testRetrieveCustomer() {
        Customer customer = new Customer();
        customer.setName("William Smith");
        customer.setEmail("smith@example.com");
        customer = customerRepository.save(customer);

        Long customerId = customer.getCustomerId();

        Customer retrievedCustomer = customerRepository.findById(customerId).orElse(null);
        assertNotNull(retrievedCustomer);
        assertEquals("William Smith", retrievedCustomer.getName());
        assertEquals("smith@example.com", retrievedCustomer.getEmail());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setName("Boby Hield");
        customer.setEmail("bob@example.com");
        customer = customerRepository.save(customer);

        Long customerId = customer.getCustomerId();

        Customer updatedCustomer = customerRepository.findById(customerId).orElse(null);
        assertNotNull(updatedCustomer);
        updatedCustomer.setName("Updated Name");
        updatedCustomer.setEmail("updated@example.com");
        customerRepository.save(updatedCustomer);

        Customer retrievedCustomer = customerRepository.findById(customerId).orElse(null);
        assertNotNull(retrievedCustomer);
        assertEquals("Updated Name", retrievedCustomer.getName());
        assertEquals("updated@example.com", retrievedCustomer.getEmail());
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setName("Eva Green");
        customer.setEmail("eva@example.com");
        customer = customerRepository.save(customer);

        Long customerId = customer.getCustomerId();

        customerRepository.deleteById(customerId);

        assertFalse(customerRepository.existsById(customerId));
    }
}
