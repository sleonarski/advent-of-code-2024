package com.orion.utils;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataParserTest {

    @Test
    void shouldParseDataFromGivenInput() {
        //given
        String path = "src/test/resources/test-input-to-parse.txt";

        //expected
        Assertions.assertEquals(List.of("1", "2", "3", "test data"), DataParser.parseDataFromPath(path));
    }
}