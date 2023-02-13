package com.learn.unittesting.business.impl;

import com.learn.unittesting.business.ItemBusinessService;
import com.learn.unittesting.models.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Override
    public Item getItem() {
        return new Item(1, "TV", "LG", 22, 2000.0);
    }
}
