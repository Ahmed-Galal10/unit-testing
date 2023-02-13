package com.learn.unittesting.business;

import com.learn.unittesting.models.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemBusinessService {
    Item getItem();
}
