package com.learn.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

    @Mock
    List<Object> listMock;

    @Test
    public void size() {
        when(listMock.size()).thenReturn(7);
        assertEquals(7, listMock.size());
    }

    @Test
    public void sizeWithDifferentValues() {
        when(listMock.size())
                .thenReturn(7)
                .thenReturn(11);
        assertEquals(7, listMock.size());
        assertEquals(11, listMock.size());
    }

    @Test
    public void sizeWithReturnParams() {
        when(listMock.get(0))
                .thenReturn("Ahmed");
        assertEquals("Ahmed", listMock.get(0));
    }
}
