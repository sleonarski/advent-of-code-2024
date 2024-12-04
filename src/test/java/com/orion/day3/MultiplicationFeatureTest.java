package com.orion.day3;

import com.orion.utils.DataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MultiplicationFeatureTest {

    @Test
    void shouldProcessMultiplication() {
        //given
        String data = DataParser.parseAsStringFromPath("src/test/resources/day3/data.txt");
        MultiplicationService multiplicationService = new MultiplicationService();
        InstructionService instructionService = new InstructionService();

        //when
        List<Instruction> instructions = instructionService.cleanAndPrepareInstructions(data);
        int result = multiplicationService.doMultiplication(instructions);

        //then
        Assertions.assertEquals(161, result);
    }
}