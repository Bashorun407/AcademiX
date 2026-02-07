package com.lytwind.academix.dto;

public record TeacherRequestDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String departmentName
) {
}
