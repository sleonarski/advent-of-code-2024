package com.orion.day2;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class ProblemDampenerReportValidator implements ReportValidator {

    private Dampener dampener;

    @Override
    public boolean checkReport(Report report) {
        dampener = new Dampener();
        var levels = report.levels();
        return areLevelsAllIncreasingOrDecreasing(levels) && areLevelsDifferValid(levels);
    }

    private boolean areLevelsAllIncreasingOrDecreasing(List<Integer> levels) {
        var reverseLevels = new ArrayList<>(levels);
        Collections.reverse(reverseLevels);
        return (isMonotonic(levels, (a, b) -> a < b) || isMonotonic(reverseLevels, (a, b) -> a > b))
                || (isMonotonic(levels, (a, b) -> a > b) || isMonotonic(reverseLevels, (a, b) -> a < b));
    }

    private boolean isMonotonic(List<Integer> levels, BiPredicate<Integer, Integer> condition) {
        boolean isValid = false;
        dampener.setActive(false);
        Integer previous = null;
        var iterator = new ArrayList<>(levels).iterator();
        while (iterator.hasNext()) {
            var current = iterator.next();

            if (previous != null) {
                if (!condition.test(previous, current)) {
                    if (dampener.isActive()) {
                        return false;
                    }
                    dampener.setActive(true);
                    iterator.remove();
                } else {
                    previous = current;
                    isValid = true;
                }
            } else {
                previous = current;
            }
        }
        return isValid;
    }

    private boolean areLevelsDifferValid(List<Integer> levels) {
        boolean isValid = false;
        dampener.setActive(false);
        Integer previous = null;
        var iterator = new ArrayList<>(levels).iterator();
        while (iterator.hasNext()) {
            var current = iterator.next();

            if (previous != null) {
                var abs = Math.abs(current - previous);
                if (!(1 <= abs && abs <= 3)) {
                    if (dampener.isActive()) {
                        return false;
                    }
                    dampener.setActive(true);
                    iterator.remove();
                } else {
                    previous = current;
                    isValid = true;
                }
            } else {
                previous = current;
            }
        }
        return isValid;
    }
}