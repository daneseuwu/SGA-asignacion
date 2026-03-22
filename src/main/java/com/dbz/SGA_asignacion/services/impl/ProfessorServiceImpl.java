package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.dto.ProfessorDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.mapper.ProfessorMapper;
import com.dbz.SGA_asignacion.model.Professor;
import com.dbz.SGA_asignacion.repository.ProfessorRepository;
import com.dbz.SGA_asignacion.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public Professor createProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.dtToModel(professorDTO);
        return professorRepository.save(professor);
    }

    @Override
    public Professor updateProfessor(Long idProfessor, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(idProfessor).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + idProfessor + " not found"));
        professorMapper.updateModelFromDto(professorDTO, professor);
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public List<Professor> getProfessorByLastName(String lastName) {
        List<Professor> professors = professorRepository.getAllProfessorByLastName(lastName);
        if (professors.isEmpty()) {
            throw new ResourceNotFoundException("No professors found with last name: " + lastName);
        }
        return professors;
    }

    @Override
    public List<Professor> getProfessorByFacultyId(Long idFaculty) {
        List<Professor> professors = professorRepository.getProfessorByIdFaculty(idFaculty);
        if (professors.isEmpty()) {
            throw new ResourceNotFoundException("No professors found for faculty ID " + idFaculty);
        }
        return professors;
    }

    @Override
    public void deleteProfessor(Long idProfessor) {
        professorRepository.findById(idProfessor).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + idProfessor + " not found"));
        professorRepository.deleteById(idProfessor);
    }

    @Override
    public Professor getProfessorById(Long idProfessor) {
        return professorRepository.findById(idProfessor).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + idProfessor + " not found"));
    }
}
