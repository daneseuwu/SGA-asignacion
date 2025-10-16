package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.CareerDTO;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Student;

import java.util.List;

public interface CareerService {
    //    create
    Career createCareer(CareerDTO careerDTO);

    //    read
    List<Career> getAllCareers();

    Career getCareerById(Long idCareer);

    List<Career> getCareerByFacultyId(Long idFaculty);

    //    update
    Career updateCareer(Long idCareer, CareerDTO careerDTO);

    //    delete
    void deleteCareer(Long idCareer);

}

