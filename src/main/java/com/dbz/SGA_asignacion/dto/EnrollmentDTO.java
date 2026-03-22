package com.dbz.SGA_asignacion.dto;

import com.dbz.SGA_asignacion.enums.StatusEnrollment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {
    @NotBlank(message = "Section is required")
    private String section;

    @NotNull(message = "Enrollment status is required")
    private StatusEnrollment estadoEnrollment;

    @NotNull(message = "Final grade is required")
    private Double notaFinal;

    @NotBlank(message = "Attendance is required")
    private String attendance;

    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Course ID is required")
    private Long courseId;
}
