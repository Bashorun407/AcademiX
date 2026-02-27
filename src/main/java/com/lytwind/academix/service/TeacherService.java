package com.lytwind.academix.service;


import com.lytwind.academix.dto.TeacherResponseDto;

import java.util.List;

public interface TeacherService {

    TeacherResponseDto createTeacher(String firstName, String lastName, String employeeId,
                                     String email, String phoneNumber, String departmentName);

    List<TeacherResponseDto> getAllTeachers();
    TeacherResponseDto assignToDepartment(Long teacherId, Long deptId);
    String removeTeacher(Long teacherId);
}
