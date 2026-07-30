package com.cfs.CREDENCE_20.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "user")
public class Report {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        @JsonIgnoreProperties("reports")// to break the circular loop
        private User user;

        @Column(columnDefinition = "TEXT")
        private String objectiveSummary; // human readable description

       //stores Data in Db as JSON
        @Column( columnDefinition = "JSON")
        private String clinicalData;  // clinic test Data like blood pressure ets

        @Column( columnDefinition = "JSON")
        private String biometricData; //  smartwatch or other sensor Data

        @Column(updatable = false)
        private LocalDateTime createdAt;

        @PrePersist
        protected void onCreate() {
            this.createdAt = LocalDateTime.now();
        }
    }


