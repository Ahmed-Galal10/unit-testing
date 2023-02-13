package com.learn.unittesting.controllers;

import com.learn.unittesting.business.ItemBusinessService;
import com.learn.unittesting.models.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    private static final String ITEM_URL = "/item";
    private static final String ITEM_BUSINESS_URL = "/item-from-business";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

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

    @Test
    public void getItemFromBusiness() throws Exception {
        // prepare itemBusiness Service
        when(itemBusinessService.getItem())
                .thenReturn(new Item(1, "TV", "LG", 22, 2000));

        // Call GET '/item' accept application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(ITEM_BUSINESS_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{name: 'TV', price: 2000}"))
                .andReturn();
    }
}