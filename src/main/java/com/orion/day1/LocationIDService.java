package com.orion.day1;

import com.orion.utils.DataParser;
import java.util.List;

public class LocationIDService {

    private final TotalDistanceCalculator totalDistanceCalculator = new TotalDistanceCalculator();
    private final SimilarityScoreCalculator similarityScoreCalculator = new SimilarityScoreCalculator();
    private final ListHolder listHolder;

    public LocationIDService(String path) {
        List<String> data = DataParser.parseDataFromPath(path);
        ListHolderPreparaotor listHolderPreparaotor = new ListHolderPreparaotor();
        this.listHolder = listHolderPreparaotor.prepareListHolder(data);
    }

    public Integer getTotalDistance() {
        return totalDistanceCalculator.calculate(listHolder);
    }

    public Integer getSimilarityScore() {
        return similarityScoreCalculator.calculate(listHolder);
    }
}
