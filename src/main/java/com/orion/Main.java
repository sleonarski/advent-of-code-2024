package com.orion;

import com.orion.day1.LocationIDService;

public class Main {

    public static void main(String[] args) {

        LocationIDService locationIDService = new LocationIDService();
        var result = locationIDService.calculateTotalDistance("src/main/resources/day1/data.txt");
        System.out.println(result);
    }
}