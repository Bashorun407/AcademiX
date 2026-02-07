package com.lytwind.academix.service;

import com.lytwind.academix.dto.ClassroomRequestDto;
import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Course;

public interface AcademicService {
    CourseResponseDto createCourse(Course course, Long deptId);
    ClassroomRequestDto setupClassroom(Classroom classroom);
}
