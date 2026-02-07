package com.lytwind.academix.service;

import com.lytwind.academix.dto.TeacherResponseDto;
import com.lytwind.academix.entity.Teacher;

public interface TeacherService {

    TeacherResponseDto assignToDepartment(Long teacherId, Long deptId);
}
