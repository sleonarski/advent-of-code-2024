package com.orion.day2;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProblemDampenerReportValidator implements ReportValidator {

    private static Logger LOG = LoggerFactory.getLogger(ProblemDampenerReportValidator.class);
    private Dampener dampener;

    @Override
    public boolean checkReport(Report report) {
        dampener = new Dampener();
        var levels = report.levels();
        var conditions = areLevelsAllIncreasingOrDecreasing(levels) && areLevelsDifferValid(levels);
        if (!conditions) {
            LOG.warn("Invalid report: {}", levels.stream().map(String::valueOf).collect(joining(", " ,"[ ", " ]")));
        }

        return conditions;
    }

    private boolean areLevelsAllIncreasingOrDecreasing(List<Integer> levels) {
        return isMonotonic(levels, (a, b) -> a < b) || isMonotonic(levels, (a, b) -> a > b);
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