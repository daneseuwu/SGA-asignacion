package com.dbz.SGA_asignacion.controller;


import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.response.CareerResponse;
import com.dbz.SGA_asignacion.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

}
