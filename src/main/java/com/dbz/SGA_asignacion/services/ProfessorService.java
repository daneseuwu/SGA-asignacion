package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.ProfessorDTO;
import com.dbz.SGA_asignacion.model.Professor;

import java.util.List;

public interface ProfessorService {
    Professor createProfessor(ProfessorDTO professorDTO);
    Professor updateProfessor(Long idProfessor, ProfessorDTO professorDTO);

    List<Professor> getAllProfessor();
    List<Professor>getProfessorByLastName(String lastName);

    List<Professor> getProfessorByFacultyId(Long idFaculty);

    void deleteProfessor(Long idProfessor);

    Professor getProfessorById(Long idProfessor);

}
