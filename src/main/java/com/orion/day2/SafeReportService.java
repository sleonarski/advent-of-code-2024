package com.orion.day2;

import java.util.List;

public class SafeReportService {

    private final ReportSafeValidator reportSafeValidator = new ReportSafeValidator();
    private final ReportPreparator reportPreparator = new ReportPreparator();

    public List<Report> prepareReport(List<String> dataList) {
        return reportPreparator.prepareReports(dataList);
    }

    public int distinctSafeReport(List<Report> reports) {
        return (int) reports.stream()
                .filter(reportSafeValidator::checkSafe)
                .count();
    }
}