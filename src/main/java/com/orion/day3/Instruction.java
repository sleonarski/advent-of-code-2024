package com.orion.day3;

public record Instruction(int number, int indicator) {

    public int multiply() {
        return number * indicator;
    }
}
