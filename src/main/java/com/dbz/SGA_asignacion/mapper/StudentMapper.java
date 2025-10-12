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

    public Student toModel(StudentDTO studentDTO) {
        Student student = new Student();

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setStudentCode(studentDTO.getStudentCode());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setStatus(studentDTO.getStatus());

        if (studentDTO.getCareerId() != null) {
            Career career = careerRepository.findById(studentDTO.getCareerId())
                    .orElseThrow(() -> new RuntimeException("Career not found with id: " + studentDTO.getCareerId()));
            student.setCareer(career);
        }


        return student;
    }

    public StudentDTO toDTO(Student student) {
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

    public void updateFromDTO(StudentDTO studentDTO, Student student) {
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setStudentCode(studentDTO.getStudentCode());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setStatus(studentDTO.getStatus());

        if (studentDTO.getCareerId() != null) {
            Career career = careerRepository.findById(studentDTO.getCareerId())
                    .orElseThrow(() -> new RuntimeException("Career not found with id: " + studentDTO.getCareerId()));
            student.setCareer(career);
        }
    }


}
