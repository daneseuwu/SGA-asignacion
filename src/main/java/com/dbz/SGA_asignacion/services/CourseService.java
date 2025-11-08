package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    List<Course> getAllCoursesByCareer(Long carerId);
    List<Course> getAllCoursesByProfessor(Long carerId);
}
