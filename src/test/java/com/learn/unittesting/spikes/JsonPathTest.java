package com.learn.unittesting.spikes;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void applyJsonPathHelpers() {

        String jsonResponse = "[{\"id\":1, \"name\":\"TV\", \"quantity\": 22}" +
                ",{\"id\":2, \"name\":\"Console\", \"quantity\": 10}]";

        DocumentContext documentContext = JsonPath.parse(jsonResponse);

        int responseLength = documentContext.read("$.length()");
        assertThat(responseLength).isEqualTo(2);

        List<String> responseNames = documentContext.read("$..name");
        assertThat(responseNames).containsExactly("TV", "Console");

        // print all the second object
        System.out.println(documentContext.read("$.[1]").toString());

        // print the name of the first two objects
        System.out.println(documentContext.read("$.[0, 1].name").toString());

        // print the object which have quantity = 10
        System.out.println(documentContext.read("$.[?(@.quantity==10)]").toString());
    }
}
