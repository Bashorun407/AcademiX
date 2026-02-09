package com.lytwind.academix.controller;

import com.lytwind.academix.dto.StudentRegisterRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.dto.StudentUpdateRequestDto;
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
    public ResponseEntity<StudentResponseDto> registerStudent(@RequestBody StudentRegisterRequestDto studentRegisterRequestDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                studentService.registerStudent(studentRegisterRequestDto.firstName(), studentRegisterRequestDto.lastName(),
                        studentRegisterRequestDto.email(), studentRegisterRequestDto.phoneNumber(),
                        studentRegisterRequestDto.studentRegNumber(),
                        studentRegisterRequestDto.dateOfBirth(), studentRegisterRequestDto.classroomNumber(),
                        studentRegisterRequestDto.guardianId()));
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long studentId){

        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long studentId,
                                                            @RequestBody StudentUpdateRequestDto studentUpdateRequestDto){

        return ResponseEntity.ok(studentService.updateStudent(studentId, studentUpdateRequestDto));
    }

    //This should be called in Guardian Service update class for auto-update
    @PutMapping("/update-guardian/{studentId}/{guardianId}")
    public ResponseEntity<StudentResponseDto> updateStudentGuardian(@PathVariable Long studentId,
                                                                    @PathVariable Long guardianId){
        return ResponseEntity.ok(studentService.updateStudentGuardian(studentId, guardianId));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
