package com.orion.day2;

import java.util.List;

class SafeReportService {

    ReportSafeValidator reportSafeValidator = new ReportSafeValidator();

    int distinctSafeReport(List<Report> reports) {
        return (int) reports.stream()
                .filter(report -> reportSafeValidator.checkSafe(report))
                .count();
    }
}