package com.lytwind.academix.dto;

public record TeacherResponseDto(
        String firstName,
        String lastName,
        String email,
        String employeeId,
        String departmentName
) {
}
