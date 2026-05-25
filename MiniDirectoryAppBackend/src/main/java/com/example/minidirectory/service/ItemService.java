package com.example.minidirectory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.minidirectory.entity.Item;
import com.example.minidirectory.model.CreateItemRequest;
import com.example.minidirectory.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item createItem(CreateItemRequest request) {

        Item item = new Item();
        item.setName(request.getName());
        item.setCategory(request.getCategory());

        return repository.save(item);
    }

    public List<Item> searchItem(String query) {

        if (query == null || query.isBlank()) {
            return repository.findAll();
        }

        return repository.findByNameContainingIgnoreCase(query);
    }
}
