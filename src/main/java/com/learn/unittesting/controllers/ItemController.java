package com.learn.unittesting.controllers;

import com.learn.unittesting.models.Item;
import com.learn.unittesting.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/item")
    public Item getItem() {
        return new Item(1, "TV", "LG", 22, 2000.0);
    }

    @GetMapping("/item-from-business")
    public Item getItemFromBusiness() {
        return itemBusinessService.getItem();
    }

    @GetMapping("/item-from-database")
    public List<Item> getItemFromDatabase() {
        return itemBusinessService.getAllItemsFromDatabase();
    }
}
