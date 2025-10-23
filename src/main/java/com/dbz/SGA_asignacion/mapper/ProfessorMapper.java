package com.dbz.SGA_asignacion.mapper;

import com.dbz.SGA_asignacion.dto.ProfessorDTO;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Faculty;
import com.dbz.SGA_asignacion.model.Professor;
import com.dbz.SGA_asignacion.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    @Autowired
    private FacultyRepository facultyRepository;

    public Professor dtToModel(ProfessorDTO dto) {
        Professor professor = new Professor();

        professor.setFirstName(dto.getFirstName());
        professor.setLastName(dto.getLastName());
        professor.setCode(dto.getCode());
        professor.setDocumentIdentity(dto.getDocumentIdentity());
        professor.setEmail(dto.getEmail());
        professor.setBirthDate(dto.getBirthDate());
        professor.setGenre(dto.getGenre());
        professor.setDirection(dto.getDirection());

        professor.setPhone(dto.getPhone());
        professor.setSpecialty(dto.getSpecialty());
        professor.setTypeContract(dto.getTypeContract());
        professor.setStatus(dto.getStatus());

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + dto.getFacultyId()));
            professor.setFaculty(faculty);
        }

        return professor;
    }

}
