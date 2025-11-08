package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.model.Course;
import com.dbz.SGA_asignacion.repository.CourseRepository;
import com.dbz.SGA_asignacion.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCoursesByCareer(Long carerId) {
        return List.of();
    }

    @Override
    public List<Course> getAllCoursesByProfessor(Long carerId) {
        return List.of();
    }
}
