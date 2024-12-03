package com.orion.testutils;

import com.orion.day2.Report;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

    public static Report prepareReport() {
        return new Report(Arrays.stream("""
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """.split("\\n"))
                .map(TestUtils::convertToLevels)
                .toList());
    }

    private static List<Integer> convertToLevels(String r) {
        return Arrays.stream(r.split("\\s"))
                .map(Integer::valueOf)
                .toList();
    }
}
