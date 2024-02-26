package com.example.eksamenbcknd2024.service;

import com.example.eksamenbcknd2024.model.Customer;
import com.example.eksamenbcknd2024.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Method to save a customer
    public Customer saveCustomer(Customer customer) {
        // Add any business logic/validation here before saving
        return customerRepository.save(customer);
    }

    // Method to retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Method to retrieve a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Method to update a customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        // Add any business logic/validation here before updating
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    // Add more fields to update as needed
                    return customerRepository.save(customer);
                })
                .orElse(null); // Or throw an exception if the customer with the given ID is not found
    }

    // Method to delete a customer by ID
    public void deleteCustomer(Long id) {
        // Add any business logic/validation here before deleting
        customerRepository.deleteById(id);
    }
}

