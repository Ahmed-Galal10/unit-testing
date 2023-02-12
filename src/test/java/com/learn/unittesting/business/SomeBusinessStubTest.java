package com.learn.unittesting.business;

import com.learn.unittesting.data.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceStubWithMultipleValues implements DataService{

    @Override
    public int[] getAllNums() {
        return new int[]{1, 3, 4};
    }
}

class DataServiceStubWithOneValue implements DataService{

    @Override
    public int[] getAllNums() {
        return new int[]{3};
    }
}

class DataServiceStubWithEmptyValues implements DataService{

    @Override
    public int[] getAllNums() {
        return new int[]{};
    }
}

public class SomeBusinessStubTest {

    @Test
    void givenMultipleValuesWhenCalculateSumThenReturnSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setDataService(new DataServiceStubWithMultipleValues());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 8;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void givenOneValueWhenCalculateSumThenReturnSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setDataService(new DataServiceStubWithOneValue());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void givenEmptyArrayWhenCalculateSumThenReturnSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setDataService(new DataServiceStubWithEmptyValues());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }
}