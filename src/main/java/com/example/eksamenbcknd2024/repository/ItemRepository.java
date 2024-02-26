package com.example.eksamenbcknd2024.repository;

import com.example.eksamenbcknd2024.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
