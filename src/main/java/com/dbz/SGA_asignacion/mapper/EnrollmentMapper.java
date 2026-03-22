package com.dbz.SGA_asignacion.mapper;

import com.dbz.SGA_asignacion.dto.EnrollmentDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Course;
import com.dbz.SGA_asignacion.model.Enrollment;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.repository.CourseRepository;
import com.dbz.SGA_asignacion.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment dtoToModel(EnrollmentDTO dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setSection(dto.getSection());
        enrollment.setEstadoEnrollment(dto.getEstadoEnrollment());
        enrollment.setNotaFinal(dto.getNotaFinal());
        enrollment.setAttendance(dto.getAttendance());

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + dto.getStudentId()));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + dto.getCourseId()));

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollment;
    }

    public void updateModelFromDto(EnrollmentDTO dto, Enrollment enrollment) {
        enrollment.setSection(dto.getSection());
        enrollment.setEstadoEnrollment(dto.getEstadoEnrollment());
        enrollment.setNotaFinal(dto.getNotaFinal());
        enrollment.setAttendance(dto.getAttendance());

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + dto.getStudentId()));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + dto.getCourseId()));

        enrollment.setStudent(student);
        enrollment.setCourse(course);
    }
}
