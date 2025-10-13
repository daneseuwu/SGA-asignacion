package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.mapper.StudentMapper;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.repository.StudentRepository;
import com.dbz.SGA_asignacion.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.dtoToModel(studentDTO);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //    @Override
//    public List<Student> getAllsStudentBydStatus(String status) {
//        return studentRepository.findStudentByStatus(status);
//    }
//    public List<Student> getStudentsByStatus(String statusStr) {
//        Status status = Status.fromString(statusStr); // Valida el string
//        return studentRepository.findByStatus(status);
//    }

    @Override
    public Optional<Student> getStudentById(Long idStudent) {
        return studentRepository.findById(idStudent);
    }

    @Override
    public List<Student> getStudentByStatus(Status status) {
        return studentRepository.findByStatus(status);
    }

    @Override
    public Student updateStudent(Long idStudent, StudentDTO studentDTO) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + idStudent));

        studentMapper.updateModelFromDto(studentDTO, student);
        return studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Long idStudent) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + idStudent));

        studentRepository.deleteById(idStudent);
    }
}
