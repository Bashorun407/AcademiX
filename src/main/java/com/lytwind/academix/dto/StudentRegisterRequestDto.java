package com.lytwind.academix.dto;

import java.time.LocalDate;

public record StudentRegisterRequestDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        LocalDate dateOfBirth,
        String classroomNumber,
        Long guardianId
) {
    public StudentRegisterRequestDto{
        if(firstName == null || lastName == null)
        {
            throw new IllegalArgumentException("First name or last name cannot be null");
        }

        if(email == null || phoneNumber == null){
            throw new IllegalArgumentException("Email or Phone number cannot be null.");
        }

        if(guardianId == null){
            throw new IllegalArgumentException("Guardian ID cannot be null.");
        }

        if(dateOfBirth == null){
            throw new IllegalArgumentException("Date of birth cannot be null.");
        }
    }
}
