package com.learn.unittesting.business.impl;

import com.learn.unittesting.business.ItemBusinessService;
import com.learn.unittesting.data.ItemRepo;
import com.learn.unittesting.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item getItem() {
        return new Item(1, "TV", "LG", 22, 2000.0);
    }

    @Override
    public List<Item> getAllItemsFromDatabase() {
        List<Item> itemList = itemRepo.findAll();

        for (Item item : itemList){
            item.setTotalValue(item.getPrice() * item.getQuantity());
        }

        return itemList;
    }
}
