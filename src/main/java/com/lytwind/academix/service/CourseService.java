package com.lytwind.academix.service;

import com.lytwind.academix.dto.CourseResponseDto;

import java.util.List;

public interface CourseService {
    CourseResponseDto createCourse(String departmentName, String courseCode, String title, int creditUnits);
    List<CourseResponseDto> allCourses();
    CourseResponseDto updateCourse(String courseCode, String title, int creditUnits, String departmentName);
    String deleteCourse(String courseCode);
}
