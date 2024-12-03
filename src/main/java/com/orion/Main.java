package com.orion;

import com.orion.day1.LocationIDService;
import com.orion.day2.Report;
import com.orion.day2.SafeReportService;
import com.orion.utils.DataParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LocationIDService locationIDService = new LocationIDService("src/main/resources/day1/data.txt");

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        var result = locationIDService.getTotalDistance();
        System.out.println(result);

        var similarityScoreResult = locationIDService.getSimilarityScore();
        System.out.println(similarityScoreResult);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        SafeReportService safeReportService = new SafeReportService();
        List<String> data = DataParser.parseDataFromPath("src/main/resources/day2/data.txt");
        List<Report> reports = safeReportService.prepareReport(data);

        int safeReportCount = safeReportService.distinctSafeReport(reports);
        System.out.println(safeReportCount);
    }
}