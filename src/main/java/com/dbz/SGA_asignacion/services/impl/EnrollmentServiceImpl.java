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
        List<Enrollment> enrollments = enrollmentRepository.findByStudentIdStudent(idStudent);
        if (enrollments.isEmpty()) {
            throw new ResourceNotFoundException("No enrollments found for student ID " + idStudent);
        }
        return enrollments;
    }

    @Override
    public Enrollment getEnrollmentById(Long idEnrollment) {
        return enrollmentRepository.findById(idEnrollment).orElseThrow(() -> new ResourceNotFoundException("Enrollment with id " + idEnrollment + " not found"));
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long idEnrollment, Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findById(idEnrollment)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment with id " + idEnrollment + " not found"));

        existingEnrollment.setSection(enrollment.getSection());
        existingEnrollment.setEstadoEnrollment(enrollment.getEstadoEnrollment());
        existingEnrollment.setNotaFinal(enrollment.getNotaFinal());
        existingEnrollment.setAttendance(enrollment.getAttendance());
        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setCourse(enrollment.getCourse());

        return enrollmentRepository.save(existingEnrollment);
    }

    @Override
    public void deleteEnrollment(Long idEnrollment) {
        enrollmentRepository.findById(idEnrollment).orElseThrow(() -> new ResourceNotFoundException("Enrollment with id " + idEnrollment + " not found"));
        enrollmentRepository.deleteById(idEnrollment);
    }
}
