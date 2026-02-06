package com.lytwind.academix.controller;

import com.lytwind.academix.dto.StudentRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long studentId){

        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        List<StudentResponseDto> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long studentId, @RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto student = studentService.updateStudent(studentId, studentRequestDto);

        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{studentId}/{guardianId}")
    public ResponseEntity<StudentResponseDto> updateStudentGuardian(@PathVariable Long studentId, @PathVariable Long guardianId){
        StudentResponseDto student = studentService.updateStudentGuardian(studentId, guardianId);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
