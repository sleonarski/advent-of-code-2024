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
        SafeReportService safeReportService = new SafeReportService();

        //when
        int report = safeReportService.distinctSafeReport(reports);

        //then
        Assertions.assertEquals(2, report);
    }
}