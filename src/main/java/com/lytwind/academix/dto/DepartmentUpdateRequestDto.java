package com.lytwind.academix.dto;

public record DepartmentUpdateRequestDto(
        String departmentName,
        String updateName
) {
    public DepartmentUpdateRequestDto{
        if(departmentName == null){
            throw new IllegalArgumentException("Department name cannot be null.");
        }

        if(updateName == null){
            throw new IllegalArgumentException("Update name cannot be null.");
        }
    }
}
