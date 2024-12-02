package com.orion.day1;

import com.orion.day1.DataFetcher.ListHolder;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PairFinderTest {


    @Test
    void shouldPairValuesInListsByLowestVal() {
        //given
        ListHolder holder = new ListHolder(List.of(1,2,3), List.of(6,5,4));
        PairFinder finder = new PairFinder();

        //when
        var pairs = finder.getPairs(holder);

        //then
        Assertions.assertEquals(List.of(new Pair(1,4), new Pair(2,5), new Pair(3,6)), pairs);
    }
}