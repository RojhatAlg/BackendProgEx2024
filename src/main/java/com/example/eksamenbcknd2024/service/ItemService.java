package com.example.eksamenbcknd2024.service;

import com.example.eksamenbcknd2024.model.Item;
import com.example.eksamenbcknd2024.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item saveItem(Item item) {
        // Add any business logic/validation here before saving
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item newItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setName(newItem.getName());
            existingItem.setPrice(newItem.getPrice());
            existingItem.setProductId(newItem.getProductId());
            // Add any other fields to update as needed
            return itemRepository.save(existingItem);
        } else {
            // Handle item not found
            return null; // Or throw an exception
        }
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
