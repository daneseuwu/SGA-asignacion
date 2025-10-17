package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.model.Faculty;
import com.dbz.SGA_asignacion.repository.FacultyRepository;
import com.dbz.SGA_asignacion.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllsFaculties() {
        return facultyRepository.findAll();
    }
}
