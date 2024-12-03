package com.orion.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class TotalDistanceCalculator implements Calculator {

    @Override
    public Integer calculate(ListHolder listHolder) {
        var pairs = getPairs(listHolder);
        return pairs.stream()
                .map(this::calculateDifference)
                .reduce(0, Integer::sum);
    }

    private List<Pair> getPairs(ListHolder holder) {
        var mutableListA = new ArrayList<>(holder.left());
        Collections.sort(mutableListA);
        var mutableListB = new ArrayList<>(holder.right());
        Collections.sort(mutableListB);
        return IntStream.range(0, holder.left().size())
                .mapToObj(i -> new Pair(mutableListA.get(i), mutableListB.get(i))).toList();
    }

    private Integer calculateDifference(Pair pair) {
        return Math.abs(pair.left() - pair.right());
    }
}
