package com.lytwind.academix.dto;

public record GuardianUpdateRequestDto(
        String email,
        String phoneNumber,
        String profession
) {
}
