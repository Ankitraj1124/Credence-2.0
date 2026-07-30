package com.cfs.CREDENCE_20.controller;
import com.cfs.CREDENCE_20.Entity.Report;
import com.cfs.CREDENCE_20.Entity.User;
import com.cfs.CREDENCE_20.dto.ClinicalReportResponse;
import com.cfs.CREDENCE_20.dto.ReportRequestDto;
import com.cfs.CREDENCE_20.service.AiGenerationService;
import com.cfs.CREDENCE_20.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> createReport(
            @AuthenticationPrincipal User currentUser,
            @RequestBody ReportRequestDto requestBody) {

        Report savedReport = reportService.createReport(currentUser.getUid(), requestBody);
        return ResponseEntity.ok(savedReport);
    }

    @GetMapping
    public ResponseEntity<List<Report>> getTimeline(
            @AuthenticationPrincipal User currentUser) {

        List<Report> timeline = reportService.getUserTimeline(currentUser.getUid());
        return ResponseEntity.ok(timeline);
    }

    @Autowired
    private AiGenerationService aiGenerationService;

    @PostMapping("/generate")
    public ResponseEntity<Report> generateAndSaveReport(
            @RequestBody List<String> chatHistory,
            @AuthenticationPrincipal User currentUser) {

        // Get clean data from AI
        ClinicalReportResponse cleanAiData = aiGenerationService.getClinicalData(chatHistory);

        // Pass to ReportService to handle the database saving
        Report savedReport = reportService.createAndSaveReport(cleanAiData, currentUser);

        // Return the saved report to the Android frontend
        return ResponseEntity.ok(savedReport);
    }
}

