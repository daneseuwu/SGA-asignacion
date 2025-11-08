package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.dto.ProfessorDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Professor;
import com.dbz.SGA_asignacion.response.ProfessorResponse;
import com.dbz.SGA_asignacion.response.StudentResponse;
import com.dbz.SGA_asignacion.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/professors")
    public ResponseEntity<?> createProfessor(@Valid @RequestBody ProfessorDTO professorDTO) {
        try {
            Professor newProfessor = professorService.createProfessor(professorDTO);
            return ResponseEntity.ok(new ProfessorResponse("Professor created successfully", newProfessor));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());

        }
    }

    @PutMapping("/professors/{idProfessor}")
    public ResponseEntity<?> updateProfessor(@PathVariable Long idProfessor, @Valid  @RequestBody ProfessorDTO professorDTO) {
        try {
            Professor updatedProfessor = professorService.updateProfessor(idProfessor, professorDTO);
            return ResponseEntity.ok(new ProfessorResponse("Professor updated successfully", updatedProfessor));

        } catch (RuntimeException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ProfessorResponse(e.getMessage(), null));

        }
    }

    @GetMapping("/professors")
    public ResponseEntity<?> getAllProfessors() {
        List<Professor> professors = professorService.getAllProfessor();
        return ResponseEntity.ok(new StudentResponse("Success", professors));
    }

    @GetMapping("/professors/{idProfessor}")
    public ResponseEntity<?> getProfessorById(@PathVariable Long idProfessor) {
        try {
            Professor professor = professorService.getProfessorById(idProfessor);
            return ResponseEntity.ok(new ProfessorResponse("Success", professor));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ProfessorResponse(e.getMessage(), null));

        }
    }

    @DeleteMapping("/professors/{idProfessor}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Long idProfessor) {
        try {
            professorService.deleteProfessor(idProfessor);
            return ResponseEntity.ok(new ProfessorResponse("Professor deleted successfully", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ProfessorResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/professors/search")
    public ResponseEntity<?> getProfessorByLastname(@RequestParam("lastName") String lastName) {
        try {
            List<Professor> professors = professorService.getProfessorByLastName(lastName);
            return ResponseEntity.ok(new ProfessorResponse("Success", professors));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ProfessorResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/professors/faculty/{idFaculty}")
    public ResponseEntity<?> getProfessorsByIdFaculty(@PathVariable Long idFaculty) {
        try {
            List<Professor> professors = professorService.getStudentByIdFaculty(idFaculty);
            return ResponseEntity.ok(new ProfessorResponse("Success", professors));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ProfessorResponse(e.getMessage(), null));
        }
    }

}
