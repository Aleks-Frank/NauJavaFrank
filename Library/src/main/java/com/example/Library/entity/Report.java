package com.example.Library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusReport statusReport;

    private String content;

    public Report() {
    }

    public Report(String content) {
        this.statusReport = StatusReport.CREATE;
        this.content = content;
    }

    public StatusReport getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(StatusReport statusReport) {
        this.statusReport = statusReport;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
