package com.example.eksamenbcknd2024.controller;

import com.amazonaws.services.iotjobsdataplane.model.ResourceNotFoundException;
import com.example.eksamenbcknd2024.model.Address;
import com.example.eksamenbcknd2024.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;


    // add ?page=0&size=2 to the end to check if it works, page is 0 and offset is 2 in exmample.
    @GetMapping("/all")
    public Page<Address> getAllAddresses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return addressRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id);
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        address.setStreet(addressDetails.getStreet());
        address.setCity(addressDetails.getCity());
        address.setPostcode(addressDetails.getPostcode());
        address.setCountry(addressDetails.getCountry());

        return addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }
}

