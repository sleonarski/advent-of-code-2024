package com.orion.day2;

import static com.orion.testutils.TestUtils.prepareReports;

import com.orion.utils.DataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportPreparatorTest {

    @Test
    void shouldPrepareReportFromInput() {
        //given
        String inputPath = "src/test/resources/day2/test-data.txt";
        var dataList = DataParser.parseDataFromPath(inputPath);
        ReportPreparator reportPreparator = new ReportPreparator();

        //when
        var report = reportPreparator.prepareReports(dataList);

        //then
        Assertions.assertEquals(prepareReports(), report);
    }
}
