package com.lytwind.academix.dto;

import com.lytwind.academix.entity.AttendanceStatus;

import java.time.LocalDate;

public record AttendanceRequestDto(
        LocalDate date,
        AttendanceStatus status
) {
}
