package com.lytwind.academix.dto;

public record DepartmentUpdateRequestDto(
        String updateName
) {
    public DepartmentUpdateRequestDto{
        if(updateName == null){
            throw new IllegalArgumentException("Update name cannot be null.");
        }
    }
}
