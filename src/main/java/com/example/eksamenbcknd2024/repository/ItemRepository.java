package com.example.eksamenbcknd2024.repository;

import com.example.eksamenbcknd2024.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
