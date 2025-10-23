package com.dbz.SGA_asignacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Long idSubject;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private Integer semester;

    @Column(nullable = false)
    private Boolean mandatory;

    @ManyToOne
    @JoinColumn(
            name = "id_professor",
            referencedColumnName = "id_professor",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_subject_professor")
    )
    private Professor professor;
}
