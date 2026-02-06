package com.lytwind.academix.dto;

import java.time.LocalDate;

public record UpdateStudentRequestDto(

        String email,
        String phoneNumber,
        String classroomNumber,
        Long guardianId
) {
}
