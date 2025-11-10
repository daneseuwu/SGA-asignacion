package com.dbz.SGA_asignacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {
    private Long idGrade;
    private String evaluationName;
    private Double score;
    private Double maxScore;
    private Double percentage;
    private LocalDateTime evaluationDate;
    private String status;
    private String studentName;
    private String courseName;

//    public GradeDTO() {}

    public GradeDTO(Long idGrade, String evaluationName, Double score, Double maxScore, Double percentage,
                    LocalDateTime evaluationDate, Enum<?> status, String studentName, String courseName) {
        this.idGrade = idGrade;
        this.evaluationName = evaluationName;
        this.score = score;
        this.maxScore = maxScore;
        this.percentage = percentage;
        this.evaluationDate = evaluationDate;
        this.status = status.name(); // convierte enum a String
        this.studentName = studentName;
        this.courseName = courseName;
    }
}
