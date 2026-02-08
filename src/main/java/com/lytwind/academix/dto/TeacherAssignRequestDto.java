package com.lytwind.academix.dto;

public record TeacherAssignRequestDto(
        Long teacherId,
        Long departmentId
) {
    public TeacherAssignRequestDto {
        if(teacherId == null){
            throw new IllegalArgumentException("Teacher ID cannot be null");
        }

        if(departmentId == null){
            throw new IllegalArgumentException("Department ID cannot be null");
        }
    }
}
