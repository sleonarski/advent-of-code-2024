package com.orion.day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MultiplicationService {

    private static final Logger LOG = LoggerFactory.getLogger(MultiplicationService.class);

    public int doMultiplication(List<Instruction> instructions) {
        int sum = instructions.stream()
                .mapToInt(instruction -> instruction.number() * instruction.indicator()).sum();
        LOG.info("Multiplication result: {}", sum);
        return sum;
    }
}
