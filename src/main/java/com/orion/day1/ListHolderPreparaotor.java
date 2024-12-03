package com.orion.day1;

import java.util.List;

class ListHolderPreparaotor {

    public static final String REGEX_PATTERN = "\\s+";

    ListHolder prepareListHolder(List<String> dataList) {
        var listA = dataList.stream()
                .map(row -> row.split(REGEX_PATTERN)[0]).toList();
        var listB = dataList.stream()
                .map(row -> row.split(REGEX_PATTERN)[1]).toList();

        return new ListHolder(mapValuesToInt(listA), mapValuesToInt(listB));
    }

    private static List<Integer> mapValuesToInt(List<String> list) {
        return list.stream().map(Integer::valueOf).toList();
    }
}