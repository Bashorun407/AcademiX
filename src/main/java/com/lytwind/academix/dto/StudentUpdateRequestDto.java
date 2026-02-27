package com.lytwind.academix.dto;

public record StudentUpdateRequestDto(

        String email,
        String phoneNumber,
        String classroomNumber
) {
    public StudentUpdateRequestDto{
        if(email == null || phoneNumber == null || classroomNumber == null){
            throw new IllegalArgumentException("Email, phone number, classroom number cannot be null");
        }
    }
}
