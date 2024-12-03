package com.orion.day1;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimilarityScoreTest {

    @Test
    void shouldCalculateSimilarityScore() {
        //given
        ListHolder listHolder = new ListHolder(List.of(3, 4, 2, 1, 3, 3), List.of(4, 3, 5, 3, 9, 3));
        Calculator similarityScoreCalculator = new SimilarityScoreCalculator();

        //when
        var result = similarityScoreCalculator.calculate(listHolder);

        //then
        Assertions.assertEquals(31, result);
    }
}