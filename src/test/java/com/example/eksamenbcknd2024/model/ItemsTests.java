package com.example.eksamenbcknd2024.model;

import com.example.eksamenbcknd2024.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ItemsTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCreateItem() {
        Item item = new Item();
        item.setName("Desk");
        item.setPrice(BigDecimal.valueOf(39.99));
        item.setProductId("DSK002");
        item = itemRepository.save(item);

        assertNotNull(item.getItemId());
        assertEquals("Desk", item.getName());
        assertEquals(BigDecimal.valueOf(39.99), item.getPrice());
        assertEquals("DSK002", item.getProductId());
    }

    @Test
    public void testRetrieveItem() {
        Item item = new Item();
        item.setName("Lamp");
        item.setPrice(BigDecimal.valueOf(19.99));
        item.setProductId("LMP001");
        item = itemRepository.save(item);

        Long itemId = item.getItemId();

        Item retrievedItem = itemRepository.findById(itemId).orElse(null);
        assertNotNull(retrievedItem);
        assertEquals("Lamp", retrievedItem.getName());
        assertEquals(BigDecimal.valueOf(19.99), retrievedItem.getPrice());
        assertEquals("LMP001", retrievedItem.getProductId());
    }
}
