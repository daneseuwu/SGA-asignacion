package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.ProfessorDTO;
import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.model.Faculty;
import com.dbz.SGA_asignacion.model.Professor;
import com.dbz.SGA_asignacion.model.Student;

import java.util.List;

public interface ProfessorService {
    Professor createProfessor(ProfessorDTO professorDTO);
    Professor updateProfessor(Long idProfessor, ProfessorDTO professorDTO);

    List<Professor> getAllProfessor();
    List<Professor>getProfessorByLastName(String lastName);

    List<Professor> getStudentByIdFaculty(Long idFaculty);

    Professor updateProfessor();

    void deleteProfessor(Long idProfessor);

    Professor getProfessorById(Long idProfessor);

}
