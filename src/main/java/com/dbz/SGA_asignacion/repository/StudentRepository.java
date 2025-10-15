package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentCode(String studentCode);

    List<Student> findByStatus(Status status);

    @Query("SELECT s FROM Student s WHERE s.career.id = :id_career")
    List<Student> getStudentByCareerId(@Param("id_career") Long idCareer);
}
