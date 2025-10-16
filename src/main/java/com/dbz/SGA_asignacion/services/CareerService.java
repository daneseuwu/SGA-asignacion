package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Student;

import java.util.List;

public interface CareerService {
    //    create
//    read
    List<Career> getAllCareers();

    Career getCareerById(Long idCareer);
    List<Career> getCareerByFacultyId(Long idFaculty);

    //    update
    void deleteCareer(Long idCareer);
//    delete
}

