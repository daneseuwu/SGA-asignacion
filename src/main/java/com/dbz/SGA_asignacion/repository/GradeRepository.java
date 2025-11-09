package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByEnrollmentStudentIdStudent(Long IdStudent);
    List<Grade> findByEnrollmentCourseIdCourse(Long Idcourse);
}
