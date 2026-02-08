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
    public FeeRequestDto{
        if(amount.equals(BigDecimal.ZERO)){
            throw new IllegalArgumentException("Amount cannot be less than or equal to zero (0)");
        }

        if (studentId == null){
            throw new IllegalArgumentException("student ID cannot be null.");
        }

        if(dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Due date cannot be before today. Enter today's date or after.");
        }
        isPaid = false;
    }

}
