package com.dbz.SGA_asignacion.controller;


import com.dbz.SGA_asignacion.dto.CareerDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.response.CareerResponse;
import com.dbz.SGA_asignacion.services.CareerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestController
@RequestMapping("/api/v1")

public class CareerController {

    @Autowired
    private CareerService careerService;

    @PostMapping("/careers")
    public ResponseEntity<CareerResponse> createCareer(@Valid @RequestBody CareerDTO careerDTO) {
        try {
            Career newCareer = careerService.createCareer(careerDTO);
            return ResponseEntity.ok(new CareerResponse("Career created successfully", newCareer));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CareerResponse("Error: " + e.getMessage(), null));
        }
    }

    @PutMapping("/careers/{idCareer}")
    public ResponseEntity<CareerResponse> updateCareer(@PathVariable Long idCareer, @Valid @RequestBody CareerDTO careerDTO){
        try {
            Career updatedCareer = careerService.updateCareer(idCareer, careerDTO);
            return ResponseEntity.ok(new CareerResponse("Career updated successfully", updatedCareer));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new CareerResponse(e.getMessage(), null));
        }
    }

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

    @DeleteMapping("/careers/{idCareer}")
    public ResponseEntity<CareerResponse> deleteCareer(@PathVariable Long idCareer) {
        try {
            careerService.deleteCareer(idCareer);
            return ResponseEntity.ok(new CareerResponse("Career deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new CareerResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/faculties/{idFaculty}/careers")
    public ResponseEntity<CareerResponse> getAllCareerByFacultyId(@PathVariable Long idFaculty) {
        try {
            List<Career> careers = careerService.getCareerByFacultyId(idFaculty);
            return ResponseEntity.ok(new CareerResponse("Success", careers));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CareerResponse(e.getMessage(), null));
        }
    }

}
