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
            return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/students")
    public ResponseEntity<StudentResponse> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(new StudentResponse("Success", students));
    }

    @GetMapping("/students/status/{status}")
    public ResponseEntity<?> getAllStudentByStatus(@PathVariable Status status) {
        List<Student> students = studentService.getStudentByStatus(status);

        if (students.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).body(status);
        }
        return ResponseEntity.ok(students);
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

    @PutMapping("/student/{idStudent}")
    public ResponseEntity<?> updatedStudent(@PathVariable Long idStudent, @Valid @RequestBody StudentDTO studentDTO) {
        try {
            Student updatedStudent = studentService.updateStudent(idStudent, studentDTO);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/student/{idStudent}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long idStudent) {
        try {
            studentService.deleteStudent(idStudent);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

}
