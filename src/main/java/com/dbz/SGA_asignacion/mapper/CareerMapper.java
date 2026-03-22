package com.dbz.SGA_asignacion.mapper;

import com.dbz.SGA_asignacion.dto.CareerDTO;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Faculty;
import com.dbz.SGA_asignacion.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CareerMapper {
    @Autowired
    private FacultyRepository facultyRepository;

    public Career dtoToModel(CareerDTO dto) {
        Career career = new Career();

        career.setName(dto.getName());
        career.setCode(dto.getCode());
        career.setDescription(dto.getDescription());
        career.setDuration(dto.getDuration());
        career.setActive(dto.getActive());

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + dto.getFacultyId()));
            career.setFaculty(faculty);
        }
        return career;
    }

    public CareerDTO modelToDTO(Career career) {
        CareerDTO dto = new CareerDTO();

        dto.setName(career.getName());
        dto.setCode(career.getCode());
        dto.setDescription(career.getDescription());
        dto.setDuration(career.getDuration());
        dto.setActive(career.getActive());

        if (career.getFaculty() != null) {
            dto.setFacultyId(career.getFaculty().getIdFaculty());
        }
        return dto;
    }

    public void updateModelFromDto(CareerDTO dto, Career career) {

        career.setName(dto.getName());
        career.setCode(dto.getCode());
        career.setDescription(dto.getDescription());
        career.setDuration(dto.getDuration());
        career.setActive(dto.getActive());

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + dto.getFacultyId()));
            career.setFaculty(faculty);
        }
    }

}
