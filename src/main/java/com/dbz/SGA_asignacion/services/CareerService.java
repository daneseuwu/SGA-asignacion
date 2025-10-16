package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.model.Career;

import java.util.List;

public interface CareerService {
    //    create
//    read
    List<Career> getAllCareers();

    Career getCareerById(Long idCareer);
//    update
//    delete
}

