package com.orion.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InstructionServiceTest {

    @Test
    void shouldCleanDataAndPrepareInstructions() {
        //given
        var data = "xmul(2,4)%&mul[3,7]mul(5555,5555)!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        InstructionService instructionService = new InstructionService();

        //when
        List<Instruction> instructions = instructionService.cleanAndPrepareInstructions(data);

        //then
        Assertions.assertEquals(List.of(
                new Instruction(2, 4),
                new Instruction(5, 5),
                new Instruction(11, 8),
                new Instruction(8, 5)
        ), instructions);
    }
}