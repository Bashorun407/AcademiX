package com.lytwind.academix.controller;

import com.lytwind.academix.dto.RegisterStudentRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.service.StudentService;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/register")
    public ResponseEntity<StudentResponseDto> registerStudent(@RequestBody RegisterStudentRequestDto registerStudentRequestDto){
        StudentResponseDto student = studentService.registerStudent(registerStudentRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
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
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long studentId, @RequestBody RegisterStudentRequestDto registerStudentRequestDto){
        StudentResponseDto student = studentService.updateStudent(studentId, registerStudentRequestDto);

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
