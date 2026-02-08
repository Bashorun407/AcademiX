package com.lytwind.academix.dto;

public record GuardianRequestDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String profession
) {
    public GuardianRequestDto{

        //Email was left out because, not all guardians have email address
        if(firstName == null){
            throw new IllegalArgumentException("First name cannot be null");
        }

        if(lastName == null){
            throw new IllegalArgumentException("Last name cannot be null");
        }

        if(phoneNumber == null){
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        if(profession == null){
            throw new IllegalArgumentException("Profession cannot be null");
        }
    }
}
