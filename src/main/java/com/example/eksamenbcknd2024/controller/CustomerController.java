package com.example.eksamenbcknd2024.controller;

import com.amazonaws.services.iotjobsdataplane.model.ResourceNotFoundException;
import com.example.eksamenbcknd2024.model.Customer;
import com.example.eksamenbcknd2024.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping()
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/all")
    public Page<Customer> getAllCustomers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return customerRepository.findAll(PageRequest.of(page, size));
    }


    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());

        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}
