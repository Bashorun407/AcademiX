package com.lytwind.academix.service;

import com.lytwind.academix.entity.Teacher;

public interface TeacherService {
    Teacher assignToDepartment(Long teacherId, Long deptId);
}
