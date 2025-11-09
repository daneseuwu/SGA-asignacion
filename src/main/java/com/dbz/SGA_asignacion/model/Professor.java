package com.dbz.SGA_asignacion.model;

import com.dbz.SGA_asignacion.enums.StatusProfessor;
import com.dbz.SGA_asignacion.enums.TypeContract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long idProfessor;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String code;

    @Column(name = "document_identity", nullable = false)
    private String documentIdentity;

    @Column(nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String specialty;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_contract", nullable = false)
    private TypeContract typeContract;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProfessor status;

    @ManyToOne
    @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty")
    private Faculty faculty;

}