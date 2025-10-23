package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.model.Faculty;
import com.dbz.SGA_asignacion.model.Professor;
import com.dbz.SGA_asignacion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor>getAllProfessorByLastName(String lastName);

    @Query("SELECT s FROM Professor s WHERE s.faculty.idFaculty = :idFaculty")
    List<Professor> getProfessorByIdFaculty(@Param("idFaculty") Long idFaculty);
}
