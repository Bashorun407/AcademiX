package com.lytwind.academix.service;

import com.lytwind.academix.dto.StudentRegisterRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.dto.StudentUpdateRequestDto;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    StudentResponseDto registerStudent(String firstName, String lastName, String email, String phoneNumber,
                                       String studentRegNumber, LocalDate dateOfBirth, String classroomNumber,
                                       Long guardianId); //Already implemented in Enrollment service
    StudentResponseDto getStudentById(Long id);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto updateStudent(Long id, StudentUpdateRequestDto studentDetails);
    String deleteStudent(Long id);
    StudentResponseDto updateStudentGuardian(Long studentId, Long guardianId);
}
