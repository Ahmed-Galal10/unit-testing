package com.learn.unittesting.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoad() throws JSONException {
        String response = this.restTemplate.getForObject("/item-from-database", String.class);
        assertEquals("[{id: 1, price:2000}, {id: 2, price:1500}, {id: 3, price:4200}]", response, false);
    }
}
