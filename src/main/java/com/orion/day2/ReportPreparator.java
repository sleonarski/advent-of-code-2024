package com.orion.day2;

import java.util.Arrays;
import java.util.List;

class ReportPreparator {

    Report prepareReport(List<String> dataList) {
        return new Report(dataList.stream()
                .map(ReportPreparator::convertToLevels)
                .toList());
    }

    private static List<Integer> convertToLevels(String r) {
        return Arrays.stream(r.split("\\s"))
                .map(Integer::valueOf)
                .toList();
    }
}
