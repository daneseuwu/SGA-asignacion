package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.dto.GradeDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.response.GradeResponse;
import com.dbz.SGA_asignacion.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/grades/student/{idStudent}")
    public ResponseEntity<GradeResponse> getGradesByStudentId(@PathVariable Long idStudent){
        try {
            List<GradeDTO> gradesStudent = gradeService.getAllGradesByIdStudent(idStudent);
            return ResponseEntity.ok(new GradeResponse("Success", gradesStudent));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GradeResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/grades/course/{idCourse}")
    public ResponseEntity<GradeResponse> getGradesByCourseId(@PathVariable Long idCourse){
        try {
            List<GradeDTO> gradesCourse = gradeService.getAllGradesByIdCourse(idCourse);
            return ResponseEntity.ok(new GradeResponse("Success", gradesCourse));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GradeResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/grades/{idGrade}")
    public ResponseEntity<GradeResponse> getGradeById(@PathVariable Long idGrade) {
        try {
            GradeDTO grade = gradeService.getGradeById(idGrade);
            return ResponseEntity.ok(new GradeResponse("Success", grade));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GradeResponse(e.getMessage(), null));
        }
    }

}
