package com.learn.unittesting.spikes;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {

    @Test
    public void applyAssertJHelpers() {
        List<Integer> numbers = Arrays.asList(8, 15, 22);

        assertThat(numbers).hasSize(3)
                .contains(15, 8)
                .allMatch(x -> x > 5)
                .noneMatch(x -> x > 25);

        assertThat("Ahmed").isNotNull().
                containsIgnoringCase("ahm")
                .startsWith("Ah")
                .endsWith("ed");
    }
}
