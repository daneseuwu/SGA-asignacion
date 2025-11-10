package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.GradeDTO;
import com.dbz.SGA_asignacion.model.Grade;

import java.util.List;

public interface GradeService {
    List<GradeDTO> getAllGradesByIdStudent(Long idStudent);
    List<GradeDTO> getAllGradesByIdCourse(Long idCourse);
}
