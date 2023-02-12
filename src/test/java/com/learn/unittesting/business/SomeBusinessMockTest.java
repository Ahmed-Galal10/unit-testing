package com.learn.unittesting.business;

import com.learn.unittesting.data.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;
    @Mock
    DataService dataServiceMock;

    @BeforeEach
    void before() {
//        MockitoAnnotations.openMocks(this);
        business.setDataService(dataServiceMock);
    }

    @Test
    void givenMultipleValuesWhenCalculateSumThenReturnSumUsingDataService() {
        when(dataServiceMock.getAllNums()).thenReturn(new int[]{1, 3, 4});
        assertEquals(8, business.calculateSumUsingDataService());
    }

    @Test
    void givenOneValueWhenCalculateSumThenReturnSumUsingDataService() {
        when(dataServiceMock.getAllNums()).thenReturn(new int[]{3});
        assertEquals(3, business.calculateSumUsingDataService());
    }

    @Test
    void givenEmptyArrayWhenCalculateSumThenReturnSumUsingDataService() {
        when(dataServiceMock.getAllNums()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumUsingDataService());
    }
}