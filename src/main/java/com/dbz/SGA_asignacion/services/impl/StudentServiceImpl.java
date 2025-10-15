package com.dbz.SGA_asignacion.services.impl;

import com.dbz.SGA_asignacion.dto.StudentDTO;
import com.dbz.SGA_asignacion.enums.Status;
import com.dbz.SGA_asignacion.exceptions.ResourceNotFoundException;
import com.dbz.SGA_asignacion.mapper.StudentMapper;
import com.dbz.SGA_asignacion.model.Student;
import com.dbz.SGA_asignacion.repository.StudentRepository;
import com.dbz.SGA_asignacion.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Student getStudentById(Long idStudent) {
        return studentRepository.findById(idStudent).orElseThrow(() -> new ResourceNotFoundException("Student with id " + idStudent + " not found"));
    }

    @Override
    public List<Student> getStudentByCareerId(Long idCareer) {
        List<Student> students = studentRepository.getStudentByCareerId(idCareer);
        if (students.isEmpty()) {
            throw new ResourceNotFoundException("No students found for career ID " + idCareer);
        }
        return students;
    }

    @Override
    public List<Student> getStudentByStatus(Status status) {
        List<Student> students = studentRepository.findByStatus(status);

        if (students.isEmpty()) {
            throw new ResourceNotFoundException("No students found with status: " + status);
        }

        return students;
    }

    @Override
    public Student updateStudent(Long idStudent, StudentDTO studentDTO) {
        Student student = studentRepository.findById(idStudent).orElseThrow(() -> new ResourceNotFoundException("Student with id " + idStudent + " not found"));

        studentMapper.updateModelFromDto(studentDTO, student);
        return studentRepository.save(student);

    }

    @Override
    public Student updateStudentStatus(Long idStudent, Status newStudentStatus) {
        Student student = studentRepository.findById(idStudent).orElseThrow(() -> new ResourceNotFoundException("Student with id " + idStudent + " not found"));

        student.setStatus(newStudentStatus);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long idStudent) {
        studentRepository.findById(idStudent).orElseThrow(() -> new ResourceNotFoundException("Student with id " + idStudent + " not found"));
    }


}
