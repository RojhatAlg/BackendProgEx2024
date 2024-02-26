package com.example.eksamenbcknd2024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;

    private String city;

    private String postcode;

    private String country;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    public Address() {
    }

    public Address(Long addressId, String street, String city, String postcode, String country, Customer customer) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.customer = customer;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
