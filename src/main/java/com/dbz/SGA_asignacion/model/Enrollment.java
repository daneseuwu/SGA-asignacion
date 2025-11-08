package com.dbz.SGA_asignacion.model;

import com.dbz.SGA_asignacion.enums.StatusEnrollment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enrollment")
    private Long idEnrollment;

    @Column(nullable = false)
    private String section;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_enrollment", nullable = false)
    private StatusEnrollment estadoEnrollment;

    @Column(name = "inscription_date")
    private LocalDateTime inscriptionDate;

    @Column(nullable = false)
    private Double notaFinal;

    @Column(nullable = false)
    private String attendance;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject", nullable = false)
    private Course course;
}
