package com.dbz.SGA_asignacion.mapper;

import com.dbz.SGA_asignacion.dto.CourseDTO;
import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.model.*;
import com.dbz.SGA_asignacion.repository.CareerRepository;
import com.dbz.SGA_asignacion.repository.FacultyRepository;
import com.dbz.SGA_asignacion.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public Course dtoToModel(CourseDTO dto) {
        Course course = new Course();

        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setCode(dto.getCode());
        course.setSemester(dto.getSemester());
        course.setIsActive(dto.getIsActive());

        if (dto.getProfessorId() != null) {
            Professor professor = professorRepository.findById(dto.getProfessorId())
                    .orElseThrow(() -> new RuntimeException("Professor not found with id: " + dto.getProfessorId()));
            course.setProfessor(professor);
        }

        if (dto.getFacultyId() != null){
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + dto.getFacultyId()));
            course.setFaculty(faculty);
        }

        if (dto.getCareerId() != null){
            Career career = careerRepository.findById(dto.getCareerId())
                    .orElseThrow(() -> new RuntimeException("Career not found with id: " + dto.getCareerId()));
            course.setCareer(career);
        }

        return course;
    }

    public void updateModelFromDto(CourseDTO dto, Course course) {

        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setCode(dto.getCode());
        course.setSemester(dto.getSemester());
        course.setIsActive(dto.getIsActive());

        if (dto.getProfessorId() != null) {
            Professor professor = professorRepository.findById(dto.getProfessorId())
                    .orElseThrow(() -> new RuntimeException("Professor not found with id: " + dto.getProfessorId()));
            course.setProfessor(professor);
        }

        if (dto.getFacultyId() != null){
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + dto.getFacultyId()));
            course.setFaculty(faculty);
        }

        if (dto.getCareerId() != null){
            Career career = careerRepository.findById(dto.getCareerId())
                    .orElseThrow(() -> new RuntimeException("Career not found with id: " + dto.getCareerId()));
            course.setCareer(career);
        }
    }

}

