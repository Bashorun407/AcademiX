package com.lytwind.academix.dto;

public record AssignTeacherRequestDto(
        Long teacherId,
        Long departmentId
) {
    public AssignTeacherRequestDto {
        if(teacherId == null){
            throw new IllegalArgumentException("Teacher ID cannot be null");
        }

        if(departmentId == null){
            throw new IllegalArgumentException("Department ID cannot be null");
        }
    }
}
