package com.orion.day2;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class ReportSafeValidator implements ReportValidator{

    @Override
    public boolean checkReport(Report report) {
        var levels = report.levels();
        return areLevelsAllIncreasingOrDecreasing(levels) && areLevelsDifferValid(levels);
    }

    private boolean areLevelsAllIncreasingOrDecreasing(List<Integer> levels) {
        return isMonotonic(levels, (a, b) -> a < b) || isMonotonic(levels, (a, b) -> a > b);
    }

    private static boolean isMonotonic(List<Integer> levels, BiPredicate<Integer, Integer> condition) {
        return IntStream.range(0, levels.size() - 1)
                .allMatch(i -> condition.test(levels.get(i), levels.get(i + 1)));
    }

    private boolean areLevelsDifferValid(List<Integer> levels) {
        return IntStream.range(0, levels.size() - 1)
                .allMatch(i -> areLevelDifferVaild(levels, i));
    }

    private static boolean areLevelDifferVaild(List<Integer> levels, int i) {
        var abs = Math.abs(levels.get(i) - levels.get(i + 1));
        return 1 <= abs && abs <= 3;
    }
}