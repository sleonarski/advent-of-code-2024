package com.orion;

import com.orion.day1.LocationIDService;

public class Main {

    public static void main(String[] args) {

        LocationIDService locationIDService = new LocationIDService("src/main/resources/day1/data.txt");
        var result = locationIDService.getTotalDistance();
        System.out.println(result);

        var similarityScoreResult = locationIDService.getSimilarityScore();
        System.out.println(similarityScoreResult);
    }
}