package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.dto.GradeDTO;
import com.dbz.SGA_asignacion.response.GradeResponse;
import com.dbz.SGA_asignacion.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?>getGradesByStudentId(@PathVariable Long idStudent){
        List<GradeDTO> gradesStudent = gradeService.getAllGradesByIdStudent(idStudent);
        return ResponseEntity.ok(new GradeResponse("Success", gradesStudent));
    }

    @GetMapping("/grades/course/{idCourse}")
    public ResponseEntity<?>getGradesByCourseId(@PathVariable Long idCourse){
    List<?> gradesCourse = gradeService.getAllGradesByIdCourse(idCourse);
        return ResponseEntity.ok(new GradeResponse("Success", gradesCourse));
    }

}
