package com.learn.unittesting.business;

import com.learn.unittesting.data.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    @Test
    void givenMultipleValuesWhenCalculateSumThenReturnSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.getAllNums()).thenReturn(new int[]{1,3,4});
        business.setDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void givenOneValueWhenCalculateSumThenReturnSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.getAllNums()).thenReturn(new int[]{3});
        business.setDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void givenEmptyArrayWhenCalculateSumThenReturnSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.getAllNums()).thenReturn(new int[]{});
        business.setDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }
}