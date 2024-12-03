package com.orion.day1;

record Pair(Integer left, Integer right) {

    static Pair of(Integer left, Integer right) {
        return new Pair(left, right);
    }
}