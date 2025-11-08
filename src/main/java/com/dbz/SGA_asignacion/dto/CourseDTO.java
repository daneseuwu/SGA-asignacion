package com.dbz.SGA_asignacion.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "Debe asignar un profesor al curso")
    private Long professorId;

    @NotNull(message = "Debe asignar una carrera al curso")
    private Long careerId;

    @NotNull(message = "Debe asignar una facultad al curso")
    private Long facultyId;

    @NotBlank(message = "El código del curso es obligatorio")
    private String code;

    @NotNull(message = "El semestre no puede ser nulo")
    private Integer semester;

    @NotNull(message = "Debe especificar si el curso está activo")
    private Boolean isActive;

}
