package com.learn.unittesting.spikes;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void applyHamcrestHelpers(){
        List<Integer> numbers = Arrays.asList(8, 15, 22);

        assertThat(numbers, hasSize(3));
        assertThat(numbers.get(1), greaterThanOrEqualTo(15));
        assertThat(numbers, everyItem(greaterThan(5)));
        assertThat(numbers, hasItems(15, 22));

        assertThat("Ahmed", containsStringIgnoringCase("hm"));
        assertThat("", is(emptyOrNullString()));
        assertThat("Ahmed", startsWith("Ahm"));
        assertThat("Ahmed", endsWith("ed"));

        assertThat(numbers, anyOf(hasItems(15, 22), everyItem(greaterThan(5))));
        assertThat(1.3, closeTo(1, 0.5));
    }
}
