package com.cfs.CREDENCE_20.service;
import com.cfs.CREDENCE_20.Entity.Report;
import com.cfs.CREDENCE_20.Entity.User;
import com.cfs.CREDENCE_20.dto.ClinicalReportResponse;
import com.cfs.CREDENCE_20.dto.ReportRequestDto;
import com.cfs.CREDENCE_20.repository.ReportRepository;
import com.cfs.CREDENCE_20.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
        private final ReportRepository reportRepository;
        private final UserRepository userRepository;

        // 1. Save a new report
        public Report createReport(String userUid, ReportRequestDto dto) {
            // Find the user who is logged in
            User user = userRepository.findByUid(userUid)
                    .orElseThrow(() -> new RuntimeException("User not found in database"));

            // Build the new report
            Report newReport = Report.builder()
                    .user(user)
                    .objectiveSummary(dto.getObjectiveSummary())
                    .clinicalData(dto.getClinicalData())
                    .biometricData(dto.getBiometricData())
                    .build();

            // Save to MySQL
            return reportRepository.save(newReport);
        }


        public List<Report> getUserTimeline(String userUid) {// 2. Fetch the Timeline Feed
            return reportRepository.findByUserUidOrderByCreatedAtDesc(userUid);
        }

        //2 part ,here it manages saves clean Ai response into Db

    // This method takes the clean AI data and the User, and handles all database logic
    public Report createAndSaveReport(ClinicalReportResponse cleanAiData, User currentUser) {

        // 1. Create a new Database Entity
        Report newReport = new Report();
        newReport.setObjectiveSummary(cleanAiData.getObjectiveSummary());
        newReport.setClinicalData(cleanAiData.getClinicalData());
        newReport.setBiometricData(cleanAiData.getBiometricData());

        // 2. Attach the user
        newReport.setUser(currentUser);

        // 3. Save and return
        return reportRepository.save(newReport);
    }
}


