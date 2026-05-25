package com.example.minidirectory.service;

import com.example.minidirectory.entity.Item;
import com.example.minidirectory.model.CreateItemRequest;
import com.example.minidirectory.repository.ItemRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

        @Mock
        private ItemRepository itemRepository;

        @InjectMocks
        private ItemService itemService;

        @Test
        void shouldReturnMatchingResult() {

                Item item = new Item();
                item.setId(1L);
                item.setName("Sherlock Holmes");
                item.setCategory("Book");

                when(itemRepository.findByNameContainingIgnoreCase("sher"))
                                .thenReturn(List.of(item));

                List<Item> result = itemService.searchItem("sher");

                assertEquals(1, result.size());
                assertEquals("Sherlock Holmes", result.get(0).getName());

                verify(itemRepository)
                                .findByNameContainingIgnoreCase("sher");
        }

        @Test
        void shouldCreateItem() {

                CreateItemRequest request = new CreateItemRequest();
                request.setName("Atomic Habits");
                request.setCategory("Book");

                Item savedItem = new Item();
                savedItem.setId(1L);
                savedItem.setName("Atomic Habits");
                savedItem.setCategory("Book");

                when(itemRepository.save(any(Item.class)))
                                .thenReturn(savedItem);

                Item result = itemService.createItem(request);

                assertNotNull(result);
                assertEquals(1L, result.getId());
                assertEquals("Atomic Habits", result.getName());
                assertEquals("Book", result.getCategory());

                verify(itemRepository, times(1))
                                .save(any(Item.class));
        }
}