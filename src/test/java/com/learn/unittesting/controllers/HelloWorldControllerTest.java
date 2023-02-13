package com.learn.unittesting.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    private static final String HELLO_URL = "/hello-world";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        // call GET "/hello-world" accept 'application/json'
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                        .get(HELLO_URL)
                                        .accept(MediaType.APPLICATION_JSON_VALUE);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        //verify "Hello World"
        assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
}