package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.model.Faculty;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.response.FacultyResponse;
import com.dbz.SGA_asignacion.response.StudentResponse;
import com.dbz.SGA_asignacion.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculties")
    public ResponseEntity<FacultyResponse> getAllsFaculties() {
        List<Faculty> faculties = facultyService.getAllsFaculties();
        return ResponseEntity.ok(new FacultyResponse("Success", faculties));
    }
}
