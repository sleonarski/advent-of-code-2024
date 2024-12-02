package com.orion.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiffCalculatorTest {

    @Test
    void shouldCalculateDifferenceInPair() {
        //given
        Pair pair = new Pair(1,3);
        DiffCalculator diffCalculator = new DiffCalculator();

        //when
        var result = diffCalculator.calculate(pair);

        //then
        Assertions.assertEquals(2, result);
    }
}