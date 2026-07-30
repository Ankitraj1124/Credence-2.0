package com.cfs.CREDENCE_20.dto;

import lombok.Data;

@Data
public class ReportRequestDto {
    private String objectiveSummary; // The human-readable text
    private String clinicalData;     // The structured AI JSON (Symptoms, ICD-10)
    private String biometricData;    // The Watch data JSON (HRV, Heart Rate)
}
