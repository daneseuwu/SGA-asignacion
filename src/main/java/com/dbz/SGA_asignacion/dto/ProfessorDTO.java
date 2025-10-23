package com.dbz.SGA_asignacion.dto;

import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.enums.StatusProfessor;
import com.dbz.SGA_asignacion.enums.TypeContract;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    @NotBlank(message = "Firstname is required")
    private String firstName;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Document identity is required")
    private String documentIdentity;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Birth date is required")
    private String birthDate;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Direction is required")
    private String direction;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Specialty is required")
    private String specialty;

    @NotNull(message = "Type contract is required")
    private TypeContract typeContract;

    @NotNull(message = "Faculty is required")
    private Long facultyId;

    @NotNull(message = "status is required")
    private StatusProfessor status;
}
