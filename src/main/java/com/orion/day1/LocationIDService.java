package com.orion.day1;

public class LocationIDService {

    PairFinder pairFinder = new PairFinder();
    DiffCalculator diffCalculator = new DiffCalculator();

    public Integer calculateTotalDistance(String path) {
        var holder = DataFetcher.parseData(path);
        var pairs = pairFinder.getPairs(holder);
        return pairs.stream()
                .map(pair -> diffCalculator.calculate(pair))
                .reduce(0, Integer::sum);
    }
}
