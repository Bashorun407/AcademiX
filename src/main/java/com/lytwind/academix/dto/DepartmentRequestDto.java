package com.lytwind.academix.dto;

public record DepartmentRequestDto(
        String name
) {
    public DepartmentRequestDto{
        if(name == null){
            throw new IllegalArgumentException("Department name cannot be null.");
        }
    }
}
