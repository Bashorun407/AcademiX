package com.lytwind.academix.controller;

import com.lytwind.academix.dto.TeacherAssignRequestDto;
import com.lytwind.academix.dto.TeacherRequestDto;
import com.lytwind.academix.dto.TeacherResponseDto;
import com.lytwind.academix.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDto> createTeacher(@RequestBody TeacherRequestDto teacherRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.createTeacher(
                teacherRequest.firstName(),
                teacherRequest.lastName(),
                teacherRequest.employeeId(),
                teacherRequest.email(),
                teacherRequest.phoneNumber(),
                teacherRequest.departmentName()
        ));
    }

    @GetMapping("/all-teachers")
    public ResponseEntity<List<TeacherResponseDto>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }
    @PutMapping
    public ResponseEntity<TeacherResponseDto> assignToDepartment(@RequestBody TeacherAssignRequestDto teacherAssignRequest){

        return ResponseEntity.ok(teacherService.assignToDepartment(
                teacherAssignRequest.teacherId(),
                teacherAssignRequest.departmentId()
        ));
    }
}
