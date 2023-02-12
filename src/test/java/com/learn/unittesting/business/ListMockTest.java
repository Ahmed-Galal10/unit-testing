package com.learn.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

    @Mock
    List<String> listMock;

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
    public void argumentCapturing(){
        listMock.add("Galal");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());

        assertEquals("Galal", captor.getValue());
    }
}
