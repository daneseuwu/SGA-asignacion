package com.dbz.SGA_asignacion.services.impl;

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
}
