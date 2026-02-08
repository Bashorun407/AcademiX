package com.lytwind.academix.dto;

public record TeacherRequestDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String departmentName
) {

    public TeacherRequestDto{
        if(firstName == null || lastName == null ){
            throw new IllegalArgumentException("First name or last name cannot be null.");
        }

        if(email == null || phoneNumber == null){
            throw new IllegalArgumentException("Email or phone number cannot be null");
        }

        if(departmentName == null){
            throw new IllegalArgumentException("Department name cannot be null.");
        }
    }
}
