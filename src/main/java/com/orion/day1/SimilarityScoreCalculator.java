package com.orion.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SimilarityScoreCalculator implements Calculator {

    private final Map<Integer, Integer> internalCache = new HashMap<>();

    @Override
    public Integer calculate(ListHolder listHolder) {
        List<Integer> similarityList = new ArrayList<>();
        var left = listHolder.left();
        var right = listHolder.right();

        for (int id : left) {
            int score;
            if (internalCache.containsKey(id)) {
                score = internalCache.get(id);
            } else {
                var frequency = Collections.frequency(right, id);
                score = id * frequency;
                internalCache.put(id, score);
            }
            similarityList.add(score);
        }
        return similarityList.stream().reduce(0, Integer::sum);
    }
}
