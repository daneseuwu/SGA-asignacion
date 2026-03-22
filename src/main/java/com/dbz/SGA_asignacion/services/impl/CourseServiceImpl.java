package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.dto.CourseDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.mapper.CourseMapper;
import com.dbz.SGA_asignacion.model.Course;
import com.dbz.SGA_asignacion.repository.CourseRepository;
import com.dbz.SGA_asignacion.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course with id " + courseId + " not found"));
    }

    @Override
    public Course createCourse(CourseDTO courseDTO) {
      Course course = courseMapper.dtoToModel(courseDTO);
      return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, CourseDTO courseDTO) {
      Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course with id " + courseId + " not found"));
      courseMapper.updateModelFromDto(courseDTO, course);
      return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course with id " + courseId + " not found"));
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> getAllCoursesByCareerId(Long careerId) {
        List<Course> courses = courseRepository.findByCareerId(careerId);
        if (courses.isEmpty()) {
            throw new ResourceNotFoundException("No courses found for career ID " + careerId);
        }
        return courses;
    }

    @Override
    public List<Course> getAllCoursesByProfessorId(Long professorId) {
        List<Course> courses = courseRepository.findByProfessorId(professorId);
        if (courses.isEmpty()) {
            throw new ResourceNotFoundException("No courses found for professor ID " + professorId);
        }
        return courses;
    }
}
