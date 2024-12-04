package com.orion.day2;

import static com.orion.testutils.TestUtils.prepareReports;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SafeReportTest {

    @Test
    void shouldDistinctSafeReports() {
        //given
        List<Report> reports = prepareReports();
        SafeReportService safeReportService = new SafeReportService(
                List.of(new ReportSafeValidator(),
                        new ProblemDampenerReportValidator()));

        //when
        safeReportService.runValidators(reports);

        //then
        Assertions.assertEquals(2, safeReportService.getReport(0));
        Assertions.assertEquals(4, safeReportService.getReport(1));
    }
}