package com.learn.unittesting.data;

import com.learn.unittesting.models.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepoTest {

    @Autowired
    ItemRepo itemRepo;

    @Test
    public void testFindAll(){
        List<Item> items = itemRepo.findAll();
        assertEquals(3, items.size());
    }
}