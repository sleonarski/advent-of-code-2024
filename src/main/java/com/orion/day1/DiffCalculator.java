package com.orion.day1;

class DiffCalculator {

    Integer calculate(Pair pair) {
        return Math.abs(pair.left() - pair.right());
    }
}
