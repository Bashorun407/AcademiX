package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Student;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FeeRequestDto(
        BigDecimal amount,
        boolean isPaid,
        LocalDate dueDate,
        Long studentId
) {
}
