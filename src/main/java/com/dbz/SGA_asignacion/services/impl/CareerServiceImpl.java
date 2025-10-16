package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.dto.CareerDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.mapper.CareerMapper;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.repository.CareerRepository;
import com.dbz.SGA_asignacion.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    CareerMapper careerMapper;

    @Override
    public Career createCareer(CareerDTO careerDTO) {
        Career career = careerMapper.dtoToModel(careerDTO);
        return careerRepository.save(career);
    }

    @Override
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    @Override
    public Career getCareerById(Long idCareer) {
        return careerRepository.findById(idCareer).orElseThrow(() -> new ResourceNotFoundException("Career with id " + idCareer + " not found"));
    }

    @Override
    public List<Career> getCareerByFacultyId(Long idFaculty) {
        List<Career> careers = careerRepository.findByFacultyId(idFaculty);
        if (careers.isEmpty()) {
            throw new ResourceNotFoundException("No careers found for faculty ID " + idFaculty);
        }
        return careers;
    }

    @Override
    public void deleteCareer(Long idCareer) {
        careerRepository.findById(idCareer).orElseThrow(() -> new ResourceNotFoundException("Career with id " + idCareer + " not found"));
        careerRepository.deleteById(idCareer);
    }
}
