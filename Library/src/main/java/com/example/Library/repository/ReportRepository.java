package com.example.Library.repository;

import com.example.Library.entity.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
}
