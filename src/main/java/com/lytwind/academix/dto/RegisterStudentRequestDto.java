package com.lytwind.academix.dto;

import java.time.LocalDate;

public record RegisterStudentRequestDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String studentRegNumber,
        LocalDate dateOfBirth,
        String classroomNumber,
        Long guardianId
) {
}
