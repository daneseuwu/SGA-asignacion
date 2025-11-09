package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Enrollment;
import com.dbz.SGA_asignacion.repository.EnrollmentRepository;
import com.dbz.SGA_asignacion.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllsEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> getEnrollmentByIdStudent(Long idStudent) {
        return enrollmentRepository.findByStudentIdStudent(idStudent);
    }

    @Override
    public Enrollment getEnrollmentById(Long idEnrollment) {
        return enrollmentRepository.findById(idEnrollment).orElseThrow(() -> new ResourceNotFoundException("Enrollment with id " + idEnrollment + " not found"));
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return null;
    }

    @Override
    public Enrollment updateEnrollment(Long idEnrollment, Enrollment enrollment) {
        return null;
    }

    @Override
    public void deleteEnrollment(Long idEnrollment) {
        enrollmentRepository.findById(idEnrollment).orElseThrow(() -> new ResourceNotFoundException("Enrollment with id " + idEnrollment + " not found"));
        enrollmentRepository.deleteById(idEnrollment);
    }
}
