package com.lytwind.academix.dto;

public record GuardianResponseDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String profession
) {
}
