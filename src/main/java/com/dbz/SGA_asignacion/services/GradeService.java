package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.model.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGradesByIdStudent(Long idStudent);
    List<Grade> getAllGradesByIdCourse(Long idCourse);
}
