package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Guardian;

import java.time.LocalDate;

public record StudentResponseDto(
        String studentFirstName,
        String studentLastName,
        String email,
        String phoneNumber,
        String roomNumber,
        String guardianFirstName,
        String guardianLastName
) {
}
