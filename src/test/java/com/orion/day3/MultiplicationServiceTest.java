package com.orion.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationServiceTest {

    @Test
    void shouldDoMultiplication() {
        //given
        MultiplicationService multiplicationService = new MultiplicationService();
        List<Instruction> instructions = List.of(
                new Instruction(2, 4),
                new Instruction(5, 5),
                new Instruction(11, 8),
                new Instruction(8, 5)
        );

        //when
        int result = multiplicationService.doMultiplication(instructions);

        //then
        Assertions.assertEquals(161, result);
    }
}