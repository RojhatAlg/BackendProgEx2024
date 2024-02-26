package com.example.eksamenbcknd2024.model;

import com.example.eksamenbcknd2024.repository.AddressRepository;
import com.example.eksamenbcknd2024.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AddressTests {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateAddress() {
        Customer customer = new Customer();
        customer.setName("Jasen tatum");
        customer.setEmail("jt@example.com");
        customer = customerRepository.save(customer);

        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("example town");
        address.setPostcode("12345");
        address.setCountry("example Country");
        address.setCustomer(customer);
        address = addressRepository.save(address);

        assertNotNull(address.getAddressId());
        assertEquals("123 Main St", address.getStreet());
        assertEquals("example town", address.getCity());
        assertEquals("12345", address.getPostcode());
        assertEquals("example Country", address.getCountry());
        assertEquals(customer, address.getCustomer());
    }

    @Test
    public void testRetrieveAddress() {
        Customer customer = new Customer();
        customer.setName("Will Smith");
        customer.setEmail("smith@example.com");
        customer = customerRepository.save(customer);

        Address address = new Address();
        address.setStreet("456 Oak St");
        address.setCity("Othertown");
        address.setPostcode("54321");
        address.setCountry("Country");
        address.setCustomer(customer);
        address = addressRepository.save(address);

        Long addressId = address.getAddressId();

        Address retrievedAddress = addressRepository.findById(addressId).orElse(null);
        assertNotNull(retrievedAddress);
        assertEquals("456 Oak St", retrievedAddress.getStreet());
        assertEquals("Othertown", retrievedAddress.getCity());
        assertEquals("54321", retrievedAddress.getPostcode());
        assertEquals("Country", retrievedAddress.getCountry());
        assertEquals(customer, retrievedAddress.getCustomer());
    }

}

