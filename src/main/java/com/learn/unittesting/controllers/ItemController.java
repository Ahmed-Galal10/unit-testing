package com.learn.unittesting.controllers;

import com.learn.unittesting.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/item")
    public Item getItem() {
        return new Item(1, "TV", "LG", 22, 2000.0);
    }
}
