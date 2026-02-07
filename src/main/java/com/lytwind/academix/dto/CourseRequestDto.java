package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Department;

public record CourseRequestDto(
        String courseCode,
        String title,
        int creditUnits,
        String departmentName
) {
    public CourseRequestDto{
        if(courseCode == null){
            throw new IllegalArgumentException("Course code cannot be null.");
        }

        if(title == null){
            throw new IllegalArgumentException("Course title cannot be null.");
        }

        if(creditUnits < 0 || creditUnits == 0){
            throw new IllegalArgumentException("Course credit units cannot be negative or a zero (0)");
        }

        if(departmentName == null){
            throw new IllegalArgumentException("Department name cannot be null.");
        }
    }
}
