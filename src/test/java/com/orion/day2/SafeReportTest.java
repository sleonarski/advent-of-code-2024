package com.orion.day2;

import static com.orion.testutils.TestUtils.prepareReport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SafeReportTest {

    @Test
    void shouldDistinctSafeReports() {
        //given
        Report reports = prepareReport();
        SafeReportService safeReportService = new SafeReportService();

        //when
        int report = safeReportService.distinctSafeReport(reports);

        //then
        Assertions.assertEquals(2, report);
    }
}
