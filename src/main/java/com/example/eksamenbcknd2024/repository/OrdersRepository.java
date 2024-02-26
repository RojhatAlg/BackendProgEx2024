package com.example.eksamenbcknd2024.repository;

import com.example.eksamenbcknd2024.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
