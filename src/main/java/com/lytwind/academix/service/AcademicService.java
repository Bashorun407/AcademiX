package com.lytwind.academix.service;

import com.lytwind.academix.dto.ClassroomDto;
import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Course;

public interface AcademicService {
    CourseResponseDto createCourse(Course course, Long deptId);
    ClassroomDto setupClassroom(Classroom classroom);
}
