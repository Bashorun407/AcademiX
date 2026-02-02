package com.lytwind.academix.dto;

import com.lytwind.academix.entity.AttendanceStatus;

import java.time.LocalDate;

public record AttendanceResponseDto(
        LocalDate date,
        AttendanceStatus status,
        String firstName,
        String lastName,
        String studentRegNumber
) {
}
