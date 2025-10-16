package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.repository.CareerRepository;
import com.dbz.SGA_asignacion.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Override
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    @Override
    public Career getCareerById(Long idCareer) {
        return careerRepository.findById(idCareer).orElseThrow(() -> new ResourceNotFoundException("Career with id " + idCareer + " not found"));
    }
}
