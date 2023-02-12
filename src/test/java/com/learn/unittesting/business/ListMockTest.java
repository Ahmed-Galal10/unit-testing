package com.learn.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

    @Mock
    List<String> listMock;
    @Mock
    ArrayList arrayListMock;

    @Spy
    ArrayList arrayListSpy;

    @Test
    public void size() {
        when(listMock.size()).thenReturn(7);
        assertEquals(7, listMock.size());
    }

    @Test
    public void sizeWithDifferentValues() {
        when(listMock.size()).thenReturn(7).thenReturn(11);
        assertEquals(7, listMock.size());
        assertEquals(11, listMock.size());
    }

    @Test
    public void sizeWithReturnSpecificParams() {
        when(listMock.get(0)).thenReturn("Ahmed");
        assertEquals("Ahmed", listMock.get(0));
    }

    @Test
    public void sizeWithReturnGenericParams() {
        when(listMock.get(anyInt())).thenReturn("Ahmed").thenReturn("Galal");
        assertEquals("Ahmed", listMock.get(0));
        assertEquals("Galal", listMock.get(4));
    }

    @Test
    public void verificationBasics() {
        String firstValue = listMock.get(0);
        String secondValue = listMock.get(1);
        String thirdValue = listMock.get(1);

        verify(listMock).get(0);

        verify(listMock, times(3)).get(anyInt());
        verify(listMock, never()).get(2);

        verify(listMock, atMost(2)).get(1);
        verify(listMock, atMostOnce()).get(0);

        verify(listMock, atLeast(1)).get(1);
        verify(listMock, atLeastOnce()).get(1);

    }

    @Test
    public void argumentCapturing() {
        listMock.add("Galal");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());

        assertEquals("Galal", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        listMock.add("Ahmed");
        listMock.add("Galal");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock, atMost(2)).add(captor.capture());
//        verify(listMock, times(2)).add(captor.capture());

        List<String> allCaptorsvalues = captor.getAllValues();

        assertEquals("Ahmed", allCaptorsvalues.get(0));
        assertEquals("Galal", allCaptorsvalues.get(1));
    }

    @Test
    public void mocking() {
        System.out.println("Checking mock behavior with original class");
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0 'default'
        arrayListMock.add("Ahmed");
        arrayListMock.add("Galal");

        System.out.println(arrayListMock.size()); // 0 as 'mock' doesn't retain the original class
        when(arrayListMock.size()).thenReturn(4);
        System.out.println(arrayListMock.size()); // 4 (after when then)
    }

    @Test
    public void spying() {
        System.out.println("Checking spy behavior with original class");
        arrayListSpy.add("Ahmed");
        System.out.println(arrayListSpy.get(0)); // Ahmed
        System.out.println(arrayListSpy.size()); // 1 'default'
        arrayListSpy.add("Galal");
        arrayListSpy.add("Galal");

        System.out.println(arrayListSpy.size()); // 3 as 'spy' retains the original class
        when(arrayListSpy.size()).thenReturn(4);
        System.out.println(arrayListSpy.size()); // 4 (after when then)
        arrayListSpy.add("test1");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.size()); // Still 4 not 5

        verify(arrayListSpy, times(2)).add("Galal");
    }
}
