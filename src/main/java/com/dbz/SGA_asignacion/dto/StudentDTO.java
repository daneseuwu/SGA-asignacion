package com.dbz.SGA_asignacion.dto;

import com.dbz.SGA_asignacion.enums.Status;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotBlank(message = "FirstName is required")
    private String firstName;

    @NotBlank(message = "LastName is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Student code is required")
    @Size(max = 10, message = "The student code cannot exceed 8 characters")
    private String studentCode;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    private LocalDateTime enrollmentDate;

    @NotNull(message = "Career is required")
    private Long careerId;

    @NotNull(message = "Status is required")
    private Status status;
}
