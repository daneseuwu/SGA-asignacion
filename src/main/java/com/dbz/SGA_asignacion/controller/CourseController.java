package com.dbz.SGA_asignacion.controller;

import com.dbz.SGA_asignacion.dto.CourseDTO;
import com.dbz.SGA_asignacion.model.Course;
import com.dbz.SGA_asignacion.response.CourseResponse;
import com.dbz.SGA_asignacion.response.ProfessorResponse;
import com.dbz.SGA_asignacion.response.StudentResponse;
import com.dbz.SGA_asignacion.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseDTO courseDTO){
        try{
            Course newCourse = courseService.createCourse(courseDTO);
            return ResponseEntity.ok(new CourseResponse("Course created successfully", newCourse));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/courses/idCourse")
    public ResponseEntity<?> updateCourse(@Valid @PathVariable Long idCourse, @RequestBody CourseDTO courseDTO ){
        try{
            Course updateCourse = courseService.updateCourse(idCourse, courseDTO);
            return ResponseEntity.ok(new CourseResponse("Course updated successfully", updateCourse));

        } catch (RuntimeException e) {
            return ResponseEntity.status(NOT_FOUND).body(new CourseResponse(e.getMessage(), null));

        }
    }


    @GetMapping("/courses")
    public ResponseEntity<?> getAllsCourses(){
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(new CourseResponse("Success", courses));

    }

    @GetMapping("/courses/{idCourse}")
    public ResponseEntity<?> getCourseById(@PathVariable Long idCourse){
       try {
           Course course = courseService.getCourseById(idCourse);
           return ResponseEntity.ok(new CourseResponse("Success", course));
       } catch (RuntimeException e) {
           return ResponseEntity.status(NOT_FOUND).body(new CourseResponse(e.getMessage(), null));
       }
    }

    @DeleteMapping("/courses/{idCourse}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long idCourse){
    try {
        courseService.deleteCourseById(idCourse);
        return ResponseEntity.ok(new CourseResponse("Course deleted successfully", null));

    } catch (RuntimeException e) {
        return ResponseEntity.status(NOT_FOUND).body(new CourseResponse(e.getMessage(), null));

    }
    }

}
