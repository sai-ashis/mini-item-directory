package com.example.minidirectory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.minidirectory.entity.Item;
import com.example.minidirectory.model.CreateItemRequest;
import com.example.minidirectory.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@Valid @RequestBody CreateItemRequest request) {
        return itemService.createItem(request);
    }

    @GetMapping
    public List<Item> searchItem(
            @RequestParam(required = false) String q) {
        return itemService.searchItem(q);
    }

}
