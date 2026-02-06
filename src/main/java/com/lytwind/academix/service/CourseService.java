package com.lytwind.academix.service;

import com.lytwind.academix.dto.CourseResponseDto;

import java.util.List;

public interface CourseService {
    CourseResponseDto createCourse(String departmentName, String courseCode, String title, int creditUnits);
    List<CourseResponseDto> allCourses();
}
