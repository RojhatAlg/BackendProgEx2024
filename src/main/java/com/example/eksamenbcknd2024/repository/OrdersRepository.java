package com.example.eksamenbcknd2024.repository;

import com.example.eksamenbcknd2024.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
