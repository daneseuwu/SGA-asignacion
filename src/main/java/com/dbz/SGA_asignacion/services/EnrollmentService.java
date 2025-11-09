package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllsEnrollments();
    Enrollment getEnrollmentById(Long idEnrollment);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(Long idEnrollment, Enrollment enrollment);
    void deleteEnrollment(Long idEnrollment);
}
