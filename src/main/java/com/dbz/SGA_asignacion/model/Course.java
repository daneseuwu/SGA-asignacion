package com.dbz.SGA_asignacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(length = 500)
    private String description;

    @NotBlank(message = "El código del curso es obligatorio")
    private String code;

    @NotNull(message = "El semestre no puede ser nulo")
    private Integer semester;

    @NotNull(message = "Debe especificar si el curso está activo")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(
            name = "id_professor",
            referencedColumnName = "id_professor",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_subject_professor")
    )

    @NotNull(message = "Debe asignar un profesor al curso")
    private Professor professor;

    @ManyToOne
    @JoinColumn(
            name = "id_career",
            referencedColumnName = "id_career",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_course_career")
    )
    @NotNull(message = "Debe asignar una carrera al curso")
    private Career career;

    @ManyToOne
    @JoinColumn(
            name = "id_faculty",
            referencedColumnName = "id_faculty",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_course_faculty")
    )
    @NotNull(message = "Debe asignar una facultad al curso")
    private Faculty faculty;
}
