package com.dbz.SGA_asignacion.services;

import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.model.Student;

import java.util.List;

public interface StudentService {

    //Crete
    Student createStudent(StudentDTO studentDTO);

    //read
    List<Student> getAllStudents();

    //update
    Student updateStudent(Long idStudent, StudentDTO studentDTO);
    Student updateStudentStatus(Long idStudent, Status newStudentStatus);

    //delete
    void deleteStudent(Long idStudent);

    //optionals
    Student getStudentById(Long idStudent);
    List<Student> getStudentByStatus(Status status);
    List<Student> getStudentByCareerId(Long idCareer);
    List<Student> getStudentByCode(String code);
}

