package com.orion.day2;

import java.util.List;
import java.util.function.BiPredicate;

class ProblemDampenerReportValidator implements ReportValidator {

    private boolean isDamped;

    @Override
    public boolean checkReport(Report report) {
        isDamped = false;
        var levels = report.levels();
        boolean conditionsValid = areLevelsAllIncreasingOrDecreasing(levels, isDamped) && areLevelsDifferValid(levels, isDamped);
        isDamped = false;
        return conditionsValid;
    }

    private boolean areLevelsAllIncreasingOrDecreasing(List<Integer> levels, boolean isDamped) {
        return isMonotonic(levels, (a, b) -> a < b, isDamped) || isMonotonic(levels, (a, b) -> a > b, isDamped);
    }

    private boolean isMonotonic(List<Integer> levels, BiPredicate<Integer, Integer> condition, boolean isDamped) {
        boolean isValid = false;
        for (int i = 0; i < levels.size() - 1; i++) {
            Integer current = levels.get(i);
            Integer previous = levels.get(i + 1);

            isValid =  condition.test(current, previous);

            if(!isValid) {
                if (isDamped) {
                    return false;
                }
                this.isDamped = true;
            }
        }
        return isValid;
    }

    private boolean areLevelsDifferValid(List<Integer> levels, boolean isDamped) {
        boolean isValid = false;
        for (int i = 0; i < levels.size() - 1; i++) {
            Integer current = levels.get(i);
            Integer previous = levels.get(i + 1);

            var abs = Math.abs(current - previous);

            isValid = 1 <= abs && abs <= 3;

            if(!isValid) {
                if (isDamped) {
                    return false;
                }
                this.isDamped = true;
            }
        }
        return isValid;
    }
}