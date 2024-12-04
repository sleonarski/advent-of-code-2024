package com.orion.utils;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataParserTest {

    @Test
    void shouldParseDataAsListFromGivenInput() {
        //given
        String path = "src/test/resources/utils/test-input-to-parse.txt";

        //expected
        Assertions.assertEquals(List.of("1", "2", "3", "test data"), DataParser.parseAsDataListFromPath(path));
    }

    @Test
    void shouldParseDataAsStringFromGivenInput() {
        //given
        String path = "src/test/resources/utils/string-input.txt";

        Assertions.assertEquals(
                "some-data-to-be-map-to-string",
                DataParser.parseAsStringFromPath(path));
    }
}