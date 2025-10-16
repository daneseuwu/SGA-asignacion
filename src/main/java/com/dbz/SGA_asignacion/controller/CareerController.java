package com.dbz.SGA_asignacion.controller;


import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.response.CareerResponse;
import com.dbz.SGA_asignacion.response.StudentResponse;
import com.dbz.SGA_asignacion.services.CareerService;
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

public class CareerController {

    @Autowired
    private CareerService careerService;

    @GetMapping("/careers")
    public ResponseEntity<CareerResponse> getAllCareers() {
        List<Career> careers = careerService.getAllCareers();
        return ResponseEntity.ok(new CareerResponse("Success", careers));
    }

    @GetMapping("/careers/{idCareer}")
    public ResponseEntity<CareerResponse> getCareerById(@PathVariable Long idCareer) {
        try {
            Career career = careerService.getCareerById(idCareer);
            return ResponseEntity.ok(new CareerResponse("Success", career));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new CareerResponse(e.getMessage(), null));
        }
    }

}
