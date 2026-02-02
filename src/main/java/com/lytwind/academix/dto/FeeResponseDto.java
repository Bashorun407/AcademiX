package com.lytwind.academix.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FeeResponseDto(
        BigDecimal amount,
        boolean isPaid,
        LocalDate dueDate,
        String firstName,
        String lastName,
        String studentRegNumber,
        String roomNumber
) {
}
