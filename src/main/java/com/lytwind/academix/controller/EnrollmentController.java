package com.lytwind.academix.controller;

import com.lytwind.academix.dto.EnrollmentRequestDto;
import com.lytwind.academix.dto.EnrollmentResponseDto;
import com.lytwind.academix.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> enrollStudent(@RequestBody EnrollmentRequestDto enrollmentRequestDto){

        EnrollmentResponseDto enrolledStudent = enrollmentService.enrollStudent(
                enrollmentRequestDto.studentId(), enrollmentRequestDto.courseCode());
        return ResponseEntity.status(HttpStatus.CREATED).body(enrolledStudent);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDto>> getAllEnrolledStudents(){
        List<EnrollmentResponseDto> enrolledStudents = enrollmentService.getAllEnrolledStudents();
        return ResponseEntity.ok(enrolledStudents);
    }
}
