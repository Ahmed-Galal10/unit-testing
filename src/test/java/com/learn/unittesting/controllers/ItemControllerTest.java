package com.learn.unittesting.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    private static final String ITEM_URL = "/item";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getItem() throws Exception {
        // Call GET '/item' accept application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(ITEM_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" + "name: \"TV\",\n" +
                        "quantity: 22,\n" +
                        "price: 2000\n" +
                        "}"))
                .andReturn();
    }
}