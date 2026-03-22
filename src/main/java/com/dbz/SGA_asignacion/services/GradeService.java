package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.GradeDTO;

import java.util.List;

public interface GradeService {
    List<GradeDTO> getAllGradesByIdStudent(Long idStudent);
    List<GradeDTO> getAllGradesByIdCourse(Long idCourse);
    GradeDTO getGradeById(Long idGrade);
}
