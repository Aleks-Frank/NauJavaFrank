package com.example.Library.service;

import com.example.Library.entity.Report;

import java.util.Optional;

public interface ReportServiceInter {

    void createReport(Report report);

    Optional<Report> findReportById(Long id);

}
