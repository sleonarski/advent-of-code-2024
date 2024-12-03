package com.orion.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.orion.utils.DataParser;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListHolderPreparaotorTest {

    @Test
    void shouldDownloadData() {
        //given
        var dataPath = "src/test/resources/day1/test-data.txt";
        var dataList = DataParser.parseDataFromPath(dataPath);
        var listHolderPreparaotor = new ListHolderPreparaotor();

        //when
        ListHolder dataLists = listHolderPreparaotor.prepareListHolder(dataList);

        //then
        assertEquals(List.of(11, 33, 55), dataLists.left());
        assertEquals(List.of(22, 44, 66), dataLists.right());
    }
}