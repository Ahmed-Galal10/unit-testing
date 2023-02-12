package com.learn.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SomeBusinessImplTest {

    @Test
    void givenMultipleValuesWhenCalculateSumThenReturnSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{1, 3, 4});
        int expectedResult = 8;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void givenOneValueWhenCalculateSumThenReturnSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{3});
        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void givenEmptyArrayWhenCalculateSumThenReturnSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }
}