package com.lytwind.academix.service;

import com.lytwind.academix.dto.RegisterStudentRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.dto.UpdateStudentRequestDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto registerStudent(RegisterStudentRequestDto registerStudentRequestDto); //Already implemented in Enrollment service
    StudentResponseDto getStudentById(Long id);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentDetails);
    String deleteStudent(Long id);
    StudentResponseDto updateStudentGuardian(Long studentId, Long guardianId);
}
