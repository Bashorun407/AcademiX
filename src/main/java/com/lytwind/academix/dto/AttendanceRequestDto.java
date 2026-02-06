package com.lytwind.academix.dto;

import com.lytwind.academix.entity.AttendanceStatus;

import java.time.LocalDate;

public record AttendanceRequestDto(
        Long studentId,
        AttendanceStatus status
) {
}
