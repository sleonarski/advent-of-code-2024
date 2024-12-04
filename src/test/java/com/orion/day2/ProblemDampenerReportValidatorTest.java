package com.orion.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ProblemDampenerReportValidatorTest {

    public static Stream<Arguments> reports() {
        return Stream.of(
                Arguments.of(new Report(List.of(7, 6, 4, 2, 1)), true),
                Arguments.of(new Report(List.of(1, 2, 7, 8, 9)), false),
                Arguments.of(new Report(List.of(9, 7, 6, 2, 1)), false),
                Arguments.of(new Report(List.of(1, 3, 2, 4, 5)), true),
                Arguments.of(new Report(List.of(8, 6, 4, 4, 1)), true),
                Arguments.of(new Report(List.of(1, 3, 6, 7, 9)), true)
        );
    }

    @ParameterizedTest
    @MethodSource("reports")
    void shouldCorrectlyValidReport(Report report, boolean expectedValidationResult) {
        //given
        var problemDampenerReportValidator = new ProblemDampenerReportValidator();

        //expected
        Assertions.assertEquals(expectedValidationResult, problemDampenerReportValidator.checkReport(report));
    }
}
/*
    7 6 4 2 1: Safe without removing any level.
    1 2 7 8 9: Unsafe regardless of which level is removed.
    9 7 6 2 1: Unsafe regardless of which level is removed.
    1 3 2 4 5: Safe by removing the second level, 3.
    8 6 4 4 1: Safe by removing the third level, 4.
    1 3 6 7 9: Safe without removing any level.
 */