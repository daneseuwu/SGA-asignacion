package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.dto.GradeDTO;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
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
    public List<GradeDTO> getAllGradesByIdStudent(Long idStudent) {
        List<GradeDTO> grades = gradeRepository.findGradesByIdStudent(idStudent);
        if (grades.isEmpty()) {
            throw new ResourceNotFoundException("No grades found for student ID " + idStudent);
        }
        return grades;
    }

    @Override
    public List<GradeDTO> getAllGradesByIdCourse(Long idCourse) {
        List<GradeDTO> grades = gradeRepository.findGradesByIdCourse(idCourse);
        if (grades.isEmpty()) {
            throw new ResourceNotFoundException("No grades found for course ID " + idCourse);
        }
        return grades;
    }

    @Override
    public GradeDTO getGradeById(Long idGrade) {
        Grade grade = gradeRepository.findById(idGrade)
                .orElseThrow(() -> new ResourceNotFoundException("Grade with id " + idGrade + " not found"));

        return new GradeDTO(
                grade.getIdGrade(),
                grade.getEvaluationName(),
                grade.getScore(),
                grade.getMaxScore(),
                grade.getPercentage(),
                grade.getEvaluationDate(),
                grade.getStatus(),
                grade.getEnrollment().getStudent().getFirstName() + " " + grade.getEnrollment().getStudent().getLastName(),
                grade.getEnrollment().getCourse().getName()
        );
    }
}
