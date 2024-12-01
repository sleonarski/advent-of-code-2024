package com.orion.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataFetcherTest {

    @Test
    void shouldDownloadData() {
        //given
        var dataPath = "src/test/resources/day1/test-data.txt";

        //when
        List<List<Integer>> dataLists = DataFetcher.parseData(dataPath);

        //then
        assertEquals(List.of(11, 33, 55), dataLists.get(0));
        assertEquals(List.of(22, 44, 66), dataLists.get(1));
    }
}