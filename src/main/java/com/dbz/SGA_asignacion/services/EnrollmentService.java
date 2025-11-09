package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.model.Enrollment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnrollmentService {
    List<Enrollment> getAllsEnrollments();
    List<Enrollment> getEnrollmentByIdStudent(Long idStudent);
    Enrollment getEnrollmentById(Long idEnrollment);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(Long idEnrollment, Enrollment enrollment);
    void deleteEnrollment(Long idEnrollment);
}
