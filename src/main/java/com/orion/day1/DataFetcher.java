package com.orion.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DataFetcher {

    static ListHolder parseData(String path) {
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String dataRow;
            while ((dataRow = reader.readLine()) != null) {
                var split = dataRow.split("\\s+");
                listA.add(split[0]);
                listB.add(split[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ListHolder(mapValuesToInt(listA), mapValuesToInt(listB));
    }

    private static List<Integer> mapValuesToInt(List<String> list) {
        return list.stream().map(Integer::valueOf).toList();
    }

    record ListHolder(List<Integer> left, List<Integer> right){}
}