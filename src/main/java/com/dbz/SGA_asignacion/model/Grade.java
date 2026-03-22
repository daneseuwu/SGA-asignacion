package com.dbz.SGA_asignacion.model;

import com.dbz.SGA_asignacion.enums.StatusGrade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Long idGrade;

    @Column(nullable = false)
    private String evaluationName;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Double maxScore;

    @Column(nullable = false)
    private Double percentage;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime evaluationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusGrade status; // Ej: "passed", "failed", "pending"

    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false)
    private Enrollment enrollment;
}
