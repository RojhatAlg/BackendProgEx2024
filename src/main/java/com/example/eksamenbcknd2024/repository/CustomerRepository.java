package com.example.eksamenbcknd2024.repository;

import com.example.eksamenbcknd2024.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

