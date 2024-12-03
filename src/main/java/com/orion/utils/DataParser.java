package com.orion.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private DataParser() {
    }

    public static List<String> parseDataFromPath(String path) {
        List<String> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String dataRow;
            while ((dataRow = reader.readLine()) != null) {
               dataList.add(dataRow);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
