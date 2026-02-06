package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Guardian;

import java.time.LocalDate;

public record StudentRequestDto(
        String firstName,
        String lastName,
        String email,
        String studentRegNumber,
        LocalDate dateOfBirth,
        String classroomNumber
) {
}
