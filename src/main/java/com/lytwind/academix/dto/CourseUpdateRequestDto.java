package com.lytwind.academix.dto;

public record CourseUpdateRequestDto(

        String title,
        int creditUnits,
        String departmentName
) {
    public CourseUpdateRequestDto{
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
