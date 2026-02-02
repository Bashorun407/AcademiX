package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Department;

public record CourseRequestDto(
        String courseCode,
        String title,
        int creditUnits,
        String departmentName
) {
}
