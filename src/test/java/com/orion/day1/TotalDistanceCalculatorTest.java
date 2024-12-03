package com.orion.day1;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TotalDistanceCalculatorTest {

    @Test
    void shouldPairValuesInListsByLowestVal() {
        //given
        ListHolder holder = new ListHolder(List.of(1,2,3), List.of(6,5,4));
        TotalDistanceCalculator calculator = new TotalDistanceCalculator();

        //when
        var result = calculator.calculate(holder);

        //then
        Assertions.assertEquals(9, result);
    }
}