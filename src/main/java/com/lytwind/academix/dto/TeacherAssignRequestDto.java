package com.lytwind.academix.dto;

public record TeacherAssignRequestDto(
        Long departmentId
) {
    public TeacherAssignRequestDto {
        if(departmentId == null){
            throw new IllegalArgumentException("Department ID cannot be null");
        }
    }
}
