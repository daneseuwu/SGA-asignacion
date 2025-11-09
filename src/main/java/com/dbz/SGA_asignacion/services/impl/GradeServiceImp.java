package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.model.Grade;
import com.dbz.SGA_asignacion.repository.GradeRepository;
import com.dbz.SGA_asignacion.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImp implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGradesByIdStudent(Long idStudent) {
        return gradeRepository.findByEnrollmentStudentIdStudent(idStudent);
    }

    @Override
    public List<Grade> getAllGradesByIdCourse(Long idCourse) {
        return gradeRepository.findByEnrollmentCourseIdCourse(idCourse);
    }
}
