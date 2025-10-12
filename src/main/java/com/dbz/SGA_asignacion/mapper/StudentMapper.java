package com.dbz.SGA_asignacion.mapper;

import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toModel(StudentDTO studentDTO) {
        Student student = new Student();

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setStudentCode(studentDTO.getStudentCode());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setEnrollmentDate(studentDTO.getEnrollmentDate());
        student.setStatus(studentDTO.getStatus());

        return student;
    }

    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();

        dto.setFirstName(dto.getFirstName());
        dto.setLastName(dto.getLastName());
        dto.setEmail(dto.getEmail());
        dto.setStudentCode(dto.getStudentCode());
        dto.setPhoneNumber(dto.getPhoneNumber());
        dto.setBirthDate(dto.getBirthDate());
        dto.setEnrollmentDate(dto.getEnrollmentDate());
        dto.setStatus(dto.getStatus());

        return dto;
    }

    public void updateFromDTO(StudentDTO studentDTO, Student student) {

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setStudentCode(studentDTO.getStudentCode());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setEnrollmentDate(studentDTO.getEnrollmentDate());
        student.setStatus(studentDTO.getStatus());
    }


}
