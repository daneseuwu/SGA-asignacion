package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.model.Enrollment;
import com.dbz.SGA_asignacion.dto.EnrollmentDTO;
import com.dbz.SGA_asignacion.mapper.EnrollmentMapper;
import com.dbz.SGA_asignacion.response.EnrollmentResponse;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @GetMapping("/enrollments")
    public ResponseEntity<EnrollmentResponse> getAllEnrollments(){
        List<Enrollment> enrollments = enrollmentService.getAllsEnrollments();
        return ResponseEntity.ok(new EnrollmentResponse("Success", enrollments));
    }

    @GetMapping("/enrollments/student/{idStudent}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentsByStudentId(@PathVariable Long idStudent){
        try {
            List<Enrollment> enrollments = enrollmentService.getEnrollmentByIdStudent(idStudent);
            return ResponseEntity.ok(new EnrollmentResponse("Success", enrollments));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EnrollmentResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/enrollments")
    public ResponseEntity<EnrollmentResponse> createEnrollment(@Valid @RequestBody EnrollmentDTO enrollmentDTO) {
        try {
            Enrollment enrollment = enrollmentMapper.dtoToModel(enrollmentDTO);
            Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);
            return ResponseEntity.ok(new EnrollmentResponse("Enrollment created successfully", createdEnrollment));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EnrollmentResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/enrollments/{idEnrollment}")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long idEnrollment,
                                                               @Valid @RequestBody EnrollmentDTO enrollmentDTO) {
        try {
            Enrollment enrollment = enrollmentMapper.dtoToModel(enrollmentDTO);
            Enrollment updatedEnrollment = enrollmentService.updateEnrollment(idEnrollment, enrollment);
            return ResponseEntity.ok(new EnrollmentResponse("Enrollment updated successfully", updatedEnrollment));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EnrollmentResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/enrollments/{idEnrollment}")
    public ResponseEntity<EnrollmentResponse> deleteEnrollment(@PathVariable Long idEnrollment) {
        try {
            enrollmentService.deleteEnrollment(idEnrollment);
            return ResponseEntity.ok(new EnrollmentResponse("Enrollment deleted successfully", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EnrollmentResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/enrollments/{idEnrollment}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long idEnrollment){
        try {
            Enrollment enrollment = enrollmentService.getEnrollmentById(idEnrollment);
            return ResponseEntity.ok(new EnrollmentResponse("Success", enrollment));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new EnrollmentResponse(e.getMessage(), null));
        }
    }

}
