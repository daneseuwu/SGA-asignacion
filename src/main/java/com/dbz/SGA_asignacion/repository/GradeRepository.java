package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.dto.GradeDTO;
import com.dbz.SGA_asignacion.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("SELECT new com.dbz.SGA_asignacion.dto.GradeDTO(g.idGrade, g.evaluationName, g.score, g.maxScore, g.percentage, g.evaluationDate, " +
            "g.status, CONCAT(s.firstName, ' ', s.lastName), c.name) " +
            "FROM Grade g " +
            "JOIN g.enrollment e " +
            "JOIN e.student s " +
            "JOIN e.course c " +
            "WHERE s.idStudent = :studentId")
    List<GradeDTO> findGradesByIdStudent(@Param("studentId") Long studentId);

    @Query("SELECT new com.dbz.SGA_asignacion.dto.GradeDTO(g.idGrade, g.evaluationName, g.score, g.maxScore, g.percentage, g.evaluationDate, g.status, " +
            "CONCAT(s.firstName, ' ', s.lastName), c.name) " +
            "FROM Grade g " +
            "JOIN g.enrollment e " +
            "JOIN e.student s " +
            "JOIN e.course c " +
            "WHERE c.idCourse = :courseId")
    List<GradeDTO> findGradesByIdCourse(@Param("courseId") Long courseId);
}
