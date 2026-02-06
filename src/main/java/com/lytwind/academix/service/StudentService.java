package com.lytwind.academix.service;

import com.lytwind.academix.dto.StudentRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    //Student registerStudent(Student student); //Already implemented in Enrollment service
    StudentResponseDto getStudentById(Long id);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto updateStudent(Long id, StudentRequestDto studentDetails);
    String deleteStudent(Long id);
    StudentResponseDto updateStudentGuardian(Long studentId, Long guardianId);
}
