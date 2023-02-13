package com.learn.unittesting.spikes;


import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{id: 1,name: \"TV\"," + "brand: \"LG\"," + "quantity: 22, price: 2000}";

    @Test
    public void jsonAssertWithStrictFalse() throws JSONException {
        //partial match with no issues with spaces
        String expectedResponse = "{name:'TV', quantity: 22, price: 2000}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssertWithStrictTrue() throws JSONException {
        //exact match except for spaces
        String expectedResponse = "{id:1,name: 'TV',brand: 'LG', quantity: 22, price: 2000}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

}
