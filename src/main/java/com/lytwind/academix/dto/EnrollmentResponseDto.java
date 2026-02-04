package com.lytwind.academix.dto;

import java.time.LocalDate;

public record EnrollmentResponseDto(
        String firstName,
        String lastName,
        String studentRegNumber,
        String courseCode,
        String title,
        String enrollmentDate
) {
}
