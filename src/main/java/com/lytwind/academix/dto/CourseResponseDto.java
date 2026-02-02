package com.lytwind.academix.dto;

public record CourseResponseDto(
        String courseCode,
        String title,
        int creditUnits,
        String departmentName
) {
}
