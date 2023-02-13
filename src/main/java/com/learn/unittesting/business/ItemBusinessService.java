package com.learn.unittesting.business;

import com.learn.unittesting.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemBusinessService {
    Item getItem();

    List<Item> getAllItemsFromDatabase();
}
