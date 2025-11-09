package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.model.Enrollment;
import com.dbz.SGA_asignacion.response.CareerResponse;
import com.dbz.SGA_asignacion.response.EnrollmentResponse;
import com.dbz.SGA_asignacion.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public ResponseEntity<?> getAllEnrollments(){
        List<Enrollment> enrollments = enrollmentService.getAllsEnrollments();
        return ResponseEntity.ok(new EnrollmentResponse("Success", enrollments));
    }

    @GetMapping("/enrollments/student/{idStudent}")
    public ResponseEntity<?>getEnrollmentsByStudentId(@PathVariable Long idStudent){
        List<Enrollment> enrollments = enrollmentService.getEnrollmentByIdStudent(idStudent);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/enrollments/{idEnrollment}")
    public ResponseEntity<?> getEnrollmentById(@PathVariable Long idEnrollment){
        try {
        Enrollment enrollment = enrollmentService.getEnrollmentById(idEnrollment);
            return ResponseEntity.ok(new EnrollmentResponse("Success", enrollment));
        } catch (RuntimeException e) {
            return ResponseEntity.status(NOT_FOUND).body(new EnrollmentResponse(e.getMessage(), null));

        }
    }

}
