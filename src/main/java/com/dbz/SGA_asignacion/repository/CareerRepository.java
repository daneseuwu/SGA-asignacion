package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {

    /// SELECT * FROM career WHERE id_faculty=14;
    @Query("SELECT c FROM Career c WHERE c.faculty.idFaculty = :idFaculty")
    List<Career> findByFacultyId(@Param("idFaculty") Long idFaculty);

}
