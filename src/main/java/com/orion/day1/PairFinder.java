package com.orion.day1;

import com.orion.day1.DataFetcher.ListHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class PairFinder {


    List<Pair> getPairs(ListHolder holder) {
        var mutableListA = new ArrayList<>(holder.left());
        Collections.sort(mutableListA);
        var mutableListB = new ArrayList<>(holder.right());
        Collections.sort(mutableListB);
        return IntStream.range(0, holder.left().size())
                .mapToObj(i -> new Pair(mutableListA.get(i), mutableListB.get(i))).toList();
    }
}
