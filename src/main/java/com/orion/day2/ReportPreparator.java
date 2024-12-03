package com.orion.day2;

import java.util.Arrays;
import java.util.List;

class ReportPreparator {

    public static final String SPLIT_PATTERN = "\\s";

    List<Report> prepareReports(List<String> dataList) {
        return dataList.stream()
                .map(ReportPreparator::convertToReport)
                .toList();
    }

    private static Report convertToReport(String rawReportData) {
        return new Report(Arrays.stream(rawReportData.split(SPLIT_PATTERN))
                .map(Integer::valueOf)
                .toList());
    }
}