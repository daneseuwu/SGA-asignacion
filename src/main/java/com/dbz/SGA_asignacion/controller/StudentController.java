package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.response.StudentResponse;
import com.dbz.SGA_asignacion.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        try {
            Student newStudent = studentService.createStudent(studentDTO);
            return ResponseEntity.ok(new StudentResponse("Product created successfully", newStudent));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/students")
    public ResponseEntity<StudentResponse> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(new StudentResponse("Success", students));
    }

    @GetMapping("/student/{idStudent}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long idStudent) {
        try {
            Student student = studentService.getStudentById(idStudent);
            return ResponseEntity.ok(new StudentResponse("Success", student));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new StudentResponse(e.getMessage(), null));
        }
    }

//    @GetMapping("/students/status/{status}")
//    public ResponseEntity<StudentResponse> getAllStudentByStatus(@PathVariable Status status) {
//        try {
//            List<Student> students = studentService.getStudentByStatus(status);
//            return ResponseEntity.ok(new StudentResponse("Success", students));
//        } catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(NOT_FOUND)
//                    .body(new StudentResponse(e.getMessage(), null));
//        }
//    }

    @GetMapping("/students/status/{status}")
    public ResponseEntity<StudentResponse> getAllStudentByStatus(@PathVariable String status) {
        try {
            Status statusEnum;
            try {
                statusEnum = Status.valueOf(status.toLowerCase());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest()
                        .body(new StudentResponse("Invalid status value. Accepted: active, graduate, suspended", null));
            }

            List<Student> students = studentService.getStudentByStatus(statusEnum);
            return ResponseEntity.ok(new StudentResponse("Success", students));

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StudentResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/students/career/{careerId}")
    public ResponseEntity<?> getAllStudentByCareerId(@PathVariable Long careerId) {
        try {
            List<Student> students = studentService.getStudentByCareerId(careerId);
            return ResponseEntity.ok(new StudentResponse("Success", students));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new StudentResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/student/{idStudent}")
    public ResponseEntity<?> updatedStudent(@PathVariable Long idStudent, @Valid @RequestBody StudentDTO studentDTO) {
        try {
            Student updatedStudent = studentService.updateStudent(idStudent, studentDTO);
            return ResponseEntity.ok(new StudentResponse("Product updated successfully", updatedStudent));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new StudentResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/student/{idStudent}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long idStudent) {
        try {
            studentService.deleteStudent(idStudent);
            return ResponseEntity.ok(new StudentResponse("Product deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new StudentResponse(e.getMessage(), null));
        }
    }

}
