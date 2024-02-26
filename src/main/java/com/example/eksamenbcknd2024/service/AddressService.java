package com.example.eksamenbcknd2024.service;

import com.example.eksamenbcknd2024.model.Address;
import com.example.eksamenbcknd2024.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address newAddress) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setStreet(newAddress.getStreet());
            existingAddress.setCity(newAddress.getCity());
            existingAddress.setPostcode(newAddress.getPostcode());
            existingAddress.setCountry(newAddress.getCountry());
            // Add any other fields to update as needed
            return addressRepository.save(existingAddress);
        } else {
            // Handle address not found
            return null; // Or throw an exception
        }
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}

