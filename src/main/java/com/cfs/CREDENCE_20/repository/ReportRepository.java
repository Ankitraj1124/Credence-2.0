package com.cfs.CREDENCE_20.repository;

import com.cfs.CREDENCE_20.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByUserUidOrderByCreatedAtDesc(String uid); //Give me all reports of a specific user, newest first
}
