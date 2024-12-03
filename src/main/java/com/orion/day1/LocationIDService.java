package com.orion.day1;

public class LocationIDService {

    private final TotalDistanceCalculator totalDistanceCalculator = new TotalDistanceCalculator();
    private final SimilarityScoreCalculator similarityScoreCalculator = new SimilarityScoreCalculator();
    private final ListHolder listHolder;

    public LocationIDService(String path) {
        this.listHolder = prepareListHolder(path);
    }

    public Integer getTotalDistance() {
        return totalDistanceCalculator.calculate(listHolder);
    }

    public Integer getSimilarityScore() {
        return similarityScoreCalculator.calculate(listHolder);
    }

    private static ListHolder prepareListHolder(String path) {
        return DataFetcher.parseData(path);
    }
}
