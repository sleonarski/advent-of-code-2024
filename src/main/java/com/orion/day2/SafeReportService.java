package com.orion.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SafeReportService {

    private static final Logger LOG = LoggerFactory.getLogger(SafeReportService.class);
    private final ReportPreparator reportPreparator = new ReportPreparator();
    private final List<ReportValidator> validators;
    private final List<Integer> safeReportsCountList = new ArrayList<>();

    public SafeReportService(List<ReportValidator> validators) {
        this.validators = List.copyOf(validators);
    }

    public List<Report> prepareReport(List<String> dataList) {
        return reportPreparator.prepareReports(dataList);
    }

    public void runValidators(List<Report> reports) {
        validators.forEach(validator -> {
            long safeReportsCount = reports.stream()
                    .filter(validator::checkReport)
                    .count();
            LOG.info("Validation count for {}: {}", validator.getClass().getSimpleName(), safeReportsCount);
            safeReportsCountList.add((int) safeReportsCount);
        });
    }

    public int getReport(int index) {
        return safeReportsCountList.get(index);
    }
}