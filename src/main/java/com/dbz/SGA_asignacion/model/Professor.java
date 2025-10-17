package com.dbz.SGA_asignacion.model;

import com.dbz.SGA_asignacion.enums.Contract;
import com.dbz.SGA_asignacion.enums.Status;
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

    @Column(name = "document_identity", nullable = false)
    private String documentIdentity;

    @Column(name = "type_document", nullable = false)
    private String typeDocument;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String birthdate;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private String phone;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String specialty;

    @Column(name = "entry_date", nullable = false)
    private String entryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_contract", nullable = false)
    private Contract typeContract;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty")
    private Faculty faculty;

}

//profile