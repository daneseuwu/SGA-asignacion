package com.dbz.SGA_asignacion.repository;

import com.dbz.SGA_asignacion.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.career.idCareer = :idCareer")
    List<Course> findByCareerId(@Param("idCareer") Long idCareer);

    @Query("SELECT c FROM Course c WHERE c.professor.idProfessor = :idProfessor")
    List<Course> findByProfessorId(@Param("idProfessor") Long idProfessor);
}
