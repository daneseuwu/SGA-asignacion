package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentIdStudent(Long idStudent);
}
