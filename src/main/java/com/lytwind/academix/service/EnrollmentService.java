package com.lytwind.academix.service;

import com.lytwind.academix.dto.EnrollmentResponseDto;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponseDto enrollStudent(Long studentId, String courseCode);
    List<EnrollmentResponseDto> getAllEnrolledStudents();
}
