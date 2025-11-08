package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.CourseDTO;
import com.dbz.SGA_asignacion.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long idCourse);

    Course createCourse(CourseDTO courseDTO);
    Course updateCourse(Long idCourse, CourseDTO courseDTO);
    void deleteCourseById(Long idCourse);

    List<Course> getAllCoursesByCareerId(Long carerId);
    List<Course> getAllCoursesByProfessorId(Long professorId);

}
