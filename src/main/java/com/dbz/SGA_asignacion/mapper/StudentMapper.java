package com.dbz.SGA_asignacion.mapper;

import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.model.Career;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    @Autowired
    private CareerRepository careerRepository;

    public Student dtoToModel(StudentDTO dto) {
        Student student = new Student();

        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setStudentCode(dto.getStudentCode());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setBirthDate(dto.getBirthDate());
        student.setStatus(dto.getStatus());

        if (dto.getCareerId() != null) {
            Career career = careerRepository.findById(dto.getCareerId())
                    .orElseThrow(() -> new RuntimeException("Career not found with id: " + dto.getCareerId()));
            student.setCareer(career);
        }

        return student;
    }

    public StudentDTO modelToDto(Student student) {
        StudentDTO dto = new StudentDTO();

        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setStudentCode(student.getStudentCode());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setBirthDate(student.getBirthDate());
        dto.setEnrollmentDate(student.getEnrollmentDate());
        dto.setStatus(student.getStatus());

        if (student.getCareer() != null) {
            dto.setCareerId(student.getCareer().getIdCareer());
        }
        return dto;
    }

    public void updateModelFromDto(StudentDTO dto, Student student) {
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setStudentCode(dto.getStudentCode());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setBirthDate(dto.getBirthDate());
        student.setStatus(dto.getStatus());

        if (dto.getCareerId() != null) {
            Career career = careerRepository.findById(dto.getCareerId())
                    .orElseThrow(() -> new RuntimeException("Career not found with id: " + dto.getCareerId()));
            student.setCareer(career);
        }
    }


}
