package com.learn.unittesting.business.impl;

import com.learn.unittesting.business.ItemBusinessService;
import com.learn.unittesting.data.ItemRepo;
import com.learn.unittesting.models.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceImplTest {

    @InjectMocks
    private ItemBusinessServiceImpl itemBusinessService;

    @Mock
    private ItemRepo itemRepo;

    @Test
    void getAllItemsFromDatabase() {
        Item item1 = new Item(1, "TV", "LG", 10, 2000);
        Item item2 =  new Item(2, "Mobile", "Samsung", 10, 1500);
        when(itemRepo.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<Item> items = itemBusinessService.getAllItemsFromDatabase();

        assertEquals(20000, items.get(0).getTotalValue());
        assertEquals(15000, items.get(1).getTotalValue());
    }
}